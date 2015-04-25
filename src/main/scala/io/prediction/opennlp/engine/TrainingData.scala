package io.prediction.opennlp.engine

import opennlp.model.DataIndexer

case class TrainingData(dataIndexer: DataIndexer) extends Serializable
