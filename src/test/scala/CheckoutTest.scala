package com.exegetics.codetest

import org.scalatest.{FlatSpec, Matchers}


class CheckoutTest extends FlatSpec with Matchers {

  val input = Array("apple", "orange", "apple", "pear" /* check matching works as expected*/)
  val basket = Basket(input)
  "A basket of two apples and an orange " should "cost £1.45" in {
    basket.calculateTotal() should be(1.45)
  }
  "A basket of two apples and an orange with BOGOF on apples" should "cost £0.85" in {
    basket.calculateTotal(Seq(Checkout.bogofApples)) should be(0.85)
  }


}
