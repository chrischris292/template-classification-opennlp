package io.prediction.opennlp.engine

import io.prediction.controller.{Engine, IEngineFactory}

object EngineFactory extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map("algo" -> classOf[Algorithm]),
      classOf[Serving])
  }
}
