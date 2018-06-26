package com.exegetics.codetest

import com.exegetics.codetest.fruit.Fruit


object Checkout {

  //entry point
  def main(args: Array[String]): Unit = {
    val basket = Basket(args)
    val totalCost = basket.calculateTotal()
    println(s"Total cost is £$totalCost")
  }


}
