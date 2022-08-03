//package com.gildedrose

class GildedRose(val items: Array[Item]) {

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


  def updateQuality() {
    for (i <- 0 until items.length) {
      var item = items(i)
      item.name match {

        case "Conjured item" =>
          reduceQuality(item)
          reduceQuality(item)
          if (!isInDate(item)) {
            reduceQuality(item)
            reduceQuality(item)
          }
          reduceSellIn(item)

        case "Aged Brie" =>
          increaseQuality(item)
          if (!isInDate(item)) {
            increaseQuality(item)
          }
          reduceSellIn(item)

        case _ =>
          if (!items(i).name.equals("Aged Brie")
            && !items(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items(i).quality > 0) {
              if (!items(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                items(i).quality = items(i).quality - 1
              }
            }
          } else {
            if (items(i).quality < 50) {
              items(i).quality = items(i).quality + 1

              if (items(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items(i).sellIn < 11) {
                  if (items(i).quality < 50) {
                    items(i).quality = items(i).quality + 1
                  }
                }

                if (items(i).sellIn < 6) {
                  if (items(i).quality < 50) {
                    items(i).quality = items(i).quality + 1
                  }
                }
              }
            }
          }

          if (!items(i).name.equals("Sulfuras, Hand of Ragnaros")) {
            items(i).sellIn = items(i).sellIn - 1
          }

          if (items(i).sellIn < 0) {
            if (!items(i).name.equals("Aged Brie")) {
              if (!items(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items(i).quality > 0) {
                  if (!items(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                    items(i).quality = items(i).quality - 1
                  }
                }
              } else {
                items(i).quality = items(i).quality - items(i).quality
              }
            } else {
              if (items(i).quality < 50) {
                items(i).quality = items(i).quality + 1
              }
            }
          }
      }
    }
  }
}