//package com.gildedrose

class GildedRose(val items: Array[Item]) {

  def updateQuality(): Unit = {
    for (i <- items.indices) {
      val item = items(i)
      item.name match {

        case "Conjured item" =>
          updateConjuredItem(item)

        case "Aged Brie" =>
          updateAgedBrie(item)

        case "Backstage passes to a TAFKAL80ETC concert" =>
          updateBackstagePass(item)

        case "Sulfuras, Hand of Ragnaros" =>
          updateSulfuras()

        case _ =>
          updateOtherItems(item)

      }
    }
  }

  // Methods to update item by item category

  private def updateConjuredItem(item: Item): Unit = {
    reduceQuality(item)
    reduceQuality(item)
    if (!isInDate(item)) {
      reduceQuality(item)
      reduceQuality(item)
    }
    reduceSellIn(item)
  }

  private def updateAgedBrie(item: Item): Unit = {
    increaseQuality(item)
    if (!isInDate(item)) {
      increaseQuality(item)
    }
    reduceSellIn(item)
  }

  private def updateBackstagePass(item: Item): Unit = {
    if (!isInDate(item)) {
      item.quality = 0
    } else {
      increaseQuality(item)
      if (item.sellIn <= 10) {
        increaseQuality(item)
      }
      if (item.sellIn <= 5) {
        increaseQuality(item)
      }
    }
    reduceSellIn(item)
  }

  private def updateSulfuras(): Unit = {}

  private def updateOtherItems(item: Item): Unit = {
    reduceQuality(item)
    if (!isInDate(item)) {
      reduceQuality(item)
    }
    reduceSellIn(item)
  }

  // Fundamental process methods

  private def isInDate(item: Item): Boolean = {
    item.sellIn >= 1
  }

  private def reduceQuality(item: Item): Unit = {
    if (item.quality >= 1) {
      item.quality -= 1
    }
  }

  private def reduceSellIn(item: Item): Unit = {
    item.sellIn -= 1
  }

  private def increaseQuality(item: Item): Unit = {
    if (item.quality <= 49) {
      item.quality += 1
    }
  }

}