package com.exegetics.codetest

import com.exegetics.codetest.fruit.Fruit

case class Basket(items: Seq[Fruit]) {
  //calculate the total cost of the fruits
  def calculateTotal(): Double = {
    items.map {
      _.price
    }.sum
  }

}

object Basket {
  // method to create a basket of fruits from list of fruit names
  def apply(names: Array[String]): Basket = {

    val fruits = names.flatMap {
      fruitName => Fruit(fruitName.toLowerCase.trim /* clean up white space and capitalisation*/)
    }
    new Basket(fruits)
  }
}