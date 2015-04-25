package io.prediction.opennlp.engine

import io.prediction.controller.LServing

class Serving extends LServing[Query, PredictedResult] {

  override def serve(
    query: Query,
    predictedResults: Seq[PredictedResult]): PredictedResult = {

    predictedResults.head
  }
}
