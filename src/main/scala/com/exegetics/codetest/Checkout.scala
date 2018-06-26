package com.exegetics.codetest

import com.exegetics.codetest.fruit.{Apple, Fruit}


object Checkout {

  // Offers
  val bogofApples = (basket: Basket) => {
    // get all the apples; pair them up and discount the second apple (should deal with odd numbers of apples)
    basket.items.collect { case x: Apple => x }.sliding(2, 2).collect { case Seq(a, b) => b.price }.sum
  }
  //entry point
  def main(args: Array[String]): Unit = {
    val basket = Basket(args)
    val totalCost = basket.calculateTotal(Seq(bogofApples))
    println(s"Total cost is £$totalCost")
  }


}
