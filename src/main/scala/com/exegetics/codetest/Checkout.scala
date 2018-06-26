package com.exegetics.codetest

import com.exegetics.codetest.fruit.Fruit

object Checkout {

  //entry point
  def main(args: Array[String]): Unit = {
    val totalCost = calculateTotal(args)
    println(s"Total cost is £$totalCost")
  }

  //calculate the total cost of the fruits
  def calculateTotal(items: Seq[String]): Double = {
    items.flatMap {
      fruitName => Fruit(fruitName.toLowerCase.trim /* clean up white space and capitalisation*/)
    }.map {
      _.price
    }.sum
  }

}
