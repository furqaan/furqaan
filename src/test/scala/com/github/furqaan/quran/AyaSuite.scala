package com.github.furqaan.quran

import scala.xml._
import org.scalatest.FunSuite
import org.scalatest.matchers.MustMatchers

class AyaSuite extends FunSuite with MustMatchers {
  def fixture =
    new {
	  val source = XML.load(getClass().getResource("/quran-simple-enhanced.xml"))
	}
  
  test("aya must contain text") {
    val f = fixture
	val aya = new Aya(((f.source \ "sura")(0) \ "aya")(0))
	aya.text must not equal (null)
  }
  
  test("first aya text must equal بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ (bismillaahi-r-rahmaani-r-rahiim)") {
    val f = fixture
	val aya = new Aya(((f.source \ "sura")(0) \ "aya")(0))
	aya.text must equal ("بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ")
  }
  
  test("last aya text must equal مِنَ الْجِنَّةِ وَالنَّاسِ (mina-l-jinnati wa-n-naasi)") {
    val f = fixture
	val aya = new Aya(((f.source \ "sura")(113) \ "aya")(5))
	aya.text must equal ("مِنَ الْجِنَّةِ وَالنَّاسِ")
  }
}