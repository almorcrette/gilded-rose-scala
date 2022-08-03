package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyWordSpec with Matchers {
//      it should "foo" in {
//        val items = Array[Item](new Item("foo", 0, 0))
//        val app = new GildedRose(items)
//        app.updateQuality()
//        app.items(0).name should equal ("foo")
//      }
  "GildedRose.updateQuality" when {
    "operating on Aged Brie" should {
      "reduce its sellIn by 1" in {
        val items = Array[Item](new Item("Aged Brie", 10, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).sellIn should equal (9)
      }
      "increases in quality by 1 (up to max 50) while sellIn is at least 1" in {

      }
      "increase in quality by 2 (up to max 50) when sellIn is 0 or less" in {

      }
      "does not increase in quality if quality already at 50" in {

      }
      "increases quality only by 1 if quality is 49 and sellIn is 0 or less" in {

      }

    }

  }
}