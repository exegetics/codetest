package com.exegetics.codetest

import org.scalatest.{FlatSpec, Matchers}


class CheckoutTest extends FlatSpec with Matchers {

  val input = Array("apple", "orange", "orange", "orange", "orange", "apple", "apple", "pear" /* check matching works as expected*/)
  val basket = Basket(input)
  "A basket of three apples and four oranges " should "cost £2.80" in {
    basket.calculateTotal() should be(0.6 * 3 + 0.25 * 4)
  }
  "A basket of three apples and four oranges with BOGOF on apples" should "cost £2.20" in {
    basket.calculateTotal(Seq(Checkout.bogofApples)) should be(2.2)
  }
  "A basket of three apples and four oranges with three for two on oranges" should "cost £2.55" in {
    basket.calculateTotal(Seq(Checkout.threeForTwoOranges)) should be(2.55)
  }
  "A basket of three apples and four oranges with both offers " should "cost £1.95" in {
    basket.calculateTotal(Seq(Checkout.threeForTwoOranges, Checkout.bogofApples)) should be(1.95)
  }
}
