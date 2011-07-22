package com.github.furqaan.quran

import scala.xml._
import org.scalatest.FunSuite
import org.scalatest.matchers.MustMatchers

class BismillahSuite extends FunSuite with MustMatchers {
  def fixture =
    new {
      val source = XML.load(getClass().getResource("/quran-simple-enhanced.xml"))
    }

  test("bismillah text must equal بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ (bismillaahi-r-rahmaani-r-rahiim)") {
    val f = fixture
	val bismillah = new Bismillah(((f.source \ "sura")(1) \ "aya")(0))
	bismillah.text must equal ("بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ")
  }
  
  test("bismillah text must equal first aya text of first sura") {
	val f = fixture
	val bismillah = new Bismillah(((f.source \ "sura")(1) \ "aya")(0))
	val firstAya = new Aya(((f.source \ "sura")(0) \ "aya")(0))
	bismillah.text must equal (firstAya.text)
  }
  
  test("bismillah text in one sura must equal bismillah text in other sura") {
	val f = fixture
	val bismillahInBaqara = new Bismillah(((f.source \ "sura")(1) \ "aya")(0))
	val bismillahInAliImraan = new Bismillah(((f.source \ "sura")(2) \ "aya")(0))
	bismillahInBaqara.text must equal (bismillahInAliImraan.text)
  }
}