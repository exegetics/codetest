package com.exegetics.codetest

import com.exegetics.codetest.fruit.{Apple, Fruit, Orange}


object Checkout {

  // Offers (calculates discount on basket)
  //buy one get one free on apples
  val bogofApples = (basket: Basket) => {
    // get all the apples; pair them up and discount the second apple (should deal with odd numbers of apples)
    basket.items.collect { case x: Apple => x }.sliding(2, 2).collect { case Seq(a, b) => b.price }.sum
  }

  // three for two on oranges
  val threeForTwoOranges = (basket: Basket) => {
    // modified bogofApples
    basket.items.collect { case x: Orange => x }.sliding(3, 3).collect { case Seq(a, b, c) => c.price }.sum
  }

  //entry point
  def main(args: Array[String]): Unit = {
    val basket = Basket(args)
    val totalCost = basket.calculateTotal(Seq(bogofApples, threeForTwoOranges))
    println(f"Total cost is £$totalCost%2.2f")
  }


}
