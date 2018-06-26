package com.exegetics.codetest

import com.exegetics.codetest.fruit.Fruit

import scala.math.BigDecimal.RoundingMode

case class Basket(items: Seq[Fruit]) {
  //calculate the total cost of the fruits with associated offers (default = no offers
  def calculateTotal(offers: Seq[Basket => Double] = Seq()): Double = {
    val totalCostWithoutDiscounts = items.map {
      _.price
    }.sum

    //apply each offer and sum discounts
    val discount = offers.map {
      _ (this)
    }.sum
    return BigDecimal(totalCostWithoutDiscounts - discount).setScale(2, RoundingMode.HALF_UP).toDouble
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