package com.exegetics.codetest.fruit

trait Fruit {
  val price: Double
}

case class Apple(price: Double = 0.60) extends Fruit

case class Orange(price: Double = 0.25) extends Fruit

//companion object to Fruit Trait
object Fruit {

  // method to create a  Fruit from a string
  def apply(s: String): Option[Fruit] = {
    s match {
      case x if x.equals("apple") => Some(new Apple)
      case x if x.equals("orange") => Some(new Orange)
      case _ => println(s"Warning: $s is neither an apple nor an orange!"); None
    }
  }
}