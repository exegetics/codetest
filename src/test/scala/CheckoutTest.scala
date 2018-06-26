package com.exegetics.codetest
import org.scalatest.{FlatSpec, Matchers}


class CheckoutTest extends FlatSpec with Matchers {

  val input = Seq("apple", "orange", "apple", "pear" /* check matching works as expected*/)

  "A basket of two apples and an orange " should "cost £1.45" in {
    Checkout.calculateTotal(input) should be(1.45)
  }


}
