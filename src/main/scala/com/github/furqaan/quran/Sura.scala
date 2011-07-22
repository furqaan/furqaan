package com.github.furqaan.quran

import scala.xml._

class Sura(source: NodeSeq, withBismillah: Boolean = false) {
  val name = (source \ "@name").text
  private val index = (source \ "@index").text
  val ayas = withBismillah match {
    case true => index match {
	  case "1" => (source \ "aya").map(aya => new Aya(aya))
	  case "9" => (source \ "aya").map(aya => new Aya(aya))
	  case _ => new Bismillah((source \ "aya")(0)) +: (source \ "aya").map(aya => new Aya(aya))
	}
	case _ => (source \ "aya").map(aya => new Aya(aya))
  }
}