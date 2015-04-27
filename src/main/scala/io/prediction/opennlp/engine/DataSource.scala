package io.prediction.opennlp.engine

import io.prediction.controller.{EmptyEvaluationInfo, EmptyParams, PDataSource}
import io.prediction.data.storage.Storage
import opennlp.maxent.BasicEventStream
import opennlp.model.OnePassDataIndexer
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import io.prediction.data.storage.DataMap
import Array._

import scala.util.Random

class DataSource(val dsp: DataSourceParams) extends PDataSource[
  TrainingData,
  EmptyEvaluationInfo,
  Query,
  String] {

  val Separator = " "

  override def readTraining(sc: SparkContext): TrainingData = {
    val trainingTreeStrings = allPhraseandInterests(sc)
    TrainingData(phraseAndInterestToTrainingData(trainingTreeStrings))
  }
  private def allPhraseandInterests(sc: SparkContext): Seq[String] = {
    val events = Storage.getPEvents().find(appId = dsp.appId, entityType = Some("phrase"))(sc)
    events.map { event =>
      val phrase = event.properties.get[String]("phrase")
      val Interest = event.properties.get[String]("Interest").replace(" ","_")
      s"$phrase $Interest"
    }.collect().toSeq


  }

  private def phraseAndInterestToTrainingData(phraseAndInterests: Seq[String]) = {

    val eventStream = new BasicEventStream(new SeqDataStream(phraseAndInterests), Separator)
    val dataIndexer = new OnePassDataIndexer(eventStream, dsp.cutoff)

    dataIndexer
  }
}
