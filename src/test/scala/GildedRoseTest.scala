package com.gildedrose

//import org.scalatest.flatspec.AnyFlatSpec
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
        val items = Array[Item](new Item("Aged Brie", 15, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).sellIn should equal (14)
      }
      "increases in quality by 1 (up to max 50) while sellIn is at least 1" in {
        val items = Array[Item](new Item("Aged Brie", 15, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal (21)
      }
      "increase in quality by 2 (up to max 50) when sellIn is 0 or less" in {
        val items = Array[Item](new Item("Aged Brie", 0, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal (22)
      }
      "does not increase in quality if quality already at 50" in {
        val items = Array[Item](new Item("Aged Brie", 15, 50))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal (50)
      }
      "increases quality only by 1 if quality is 49 and sellIn is 0 or less" in {
        val items = Array[Item](new Item("Aged Brie", 0, 49))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal (50)
      }
    }
    "operating on Backstage passes" should {
      "reduce its sellIn by 1" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).sellIn should equal(14)
      }
      "increases in quality by 1 (up to max 50) while sellIn is at least 11" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal(21)
      }
      "increases in quality by 2 (up to max 50) while sellIn is between 6 and 10" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal(22)
      }
      "increases in quality by 3 (up to max 50) while sellIn is between 0 and 5" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal(23)
      }
      "does not increase in quality if quality already at 50" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal(50)
      }
      "quality falls to 0 when sellIn is 0" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).quality should equal(0)
      }
    }
  }
}