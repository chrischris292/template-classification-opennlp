package io.prediction.opennlp.engine

import opennlp.maxent.DataStream

class SeqDataStream(val data: Seq[String]) extends DataStream {
  private var next = 0

  override def hasNext: Boolean = {
    data.size > next
  }

  override def nextToken(): String = {
    val nextToken = data(next)
    next += 1
    nextToken
  }
}
