package com.github.furqaan.quran

import scala.xml._

class Aya(source: NodeSeq) {
  val text = (source \ "@text").text
}