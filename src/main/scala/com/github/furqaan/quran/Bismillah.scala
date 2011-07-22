package com.github.furqaan.quran

import scala.xml._

class Bismillah(source: NodeSeq) extends Aya(source: NodeSeq) {
  override val text = (source \ "@bismillah").text
}