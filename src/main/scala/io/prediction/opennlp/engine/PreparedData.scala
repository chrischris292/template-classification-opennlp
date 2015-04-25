package io.prediction.opennlp.engine

import opennlp.model.DataIndexer
import scala.collection.Map

case class PreparedData(dataIndexer: DataIndexer) extends Serializable
