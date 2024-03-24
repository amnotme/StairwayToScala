package lectures.part3

object WhatIsAFunction extends App {

  trait MyFunction[A, B] {
    def apply(element: A): B
  }
  // DREAM use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))



  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  // Function Types Function2[A, B, R] === (A, B) => R
  // All scala functions are objects
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }


  println(adder(2, 4))

  /*
    1. a function which takes 2 strings and concatenates them
    3. define a function which takes an int and returns another function which takes an int and
  returns an int
    - what's the type of this function
    - how to do it?
   */

  def concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = s"$v1$v2"
  }

  println(concatenator("This is is", " kind of cool"))

  def superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))

  println(superAdder(3)(4))

}


