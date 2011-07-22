package com.github.furqaan.quran

import scala.xml._

class Quran(source: Elem, withBismillah: Boolean = false) {
  val suras = (source \ "sura").map(sura => new Sura(sura, withBismillah))
}

object Quran {
  def fromFile(name: String, withBismillah: Boolean = false): Quran = new Quran(XML.loadFile(name), withBismillah)
}