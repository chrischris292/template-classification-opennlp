package io.prediction.opennlp.engine

import io.prediction.controller.Params

case class DataSourceParams(
  appId: Int,
  cutoff: Int) extends Params
