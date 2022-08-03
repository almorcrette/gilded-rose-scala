# Gilded Rose in Scala

This is my solution to the gilded Rose kata in Scala. Used to practise Scala fundamentals during week 2 of Makers Accelerator Scala training course.

## Client requirements

### Instruction from the kata

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a prominent city run by a friendly innkeeper named Allison. We also buy and sell only the finest goods. Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that we can begin selling a new category of items. First an introduction to our system:

- All items have a SellIn value which denotes the number of days we have to sell the item.
- All items have a Quality value which denotes how valuable the item is.
- At the end of each day our system lowers both values for every item.

Pretty simple, right? Well this is where it gets interesting:

- Once the sell by date has passed, Quality degrades twice as fast
- The Quality of an item is never negative
- “Aged Brie” actually increases in Quality the older it gets
- The Quality of an item is never more than 50
- “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality
- “Backstage passes”, like aged brie, increases in Quality as it’s SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

- “Conjured” items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still works correctly. However, do not alter the Item class or Items property as those belong to the goblin in the corner who will insta-rage and one-shot you as he doesn’t believe in shared code ownership (you can make the UpdateQuality method and Items property static if you like, we’ll cover for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a legendary and as such its Quality is 80 and it never alters.

## Usage

### Get started (installing the code)

Clone the repo locally: `git clone https://github.com/almorcrette/gilded-rose-scala.git`

### Usage (executing the program)

First compile:

`sbt compile`

Then launch the REPL loading the program:

`scala -classpath target/scala-2.13/classes`

From within the REPL, you can explore the functionality. For example:

Set up the shop with some items:

```
val items = Array[Item](
    new Item("other item", 15, 20),
    new Item("Aged Brie", 15, 20),
    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
    new Item("Sulfuras, Hand of Ragnaros", 15, 20),
    new Item("Conjured item", 15, 20)
    )
    
val shop = new GildedRose(items)
```

Then update the quality of the items day-by-day with:`shop.updateQuality()`

### Running tests

`sbt test`

## About the code
