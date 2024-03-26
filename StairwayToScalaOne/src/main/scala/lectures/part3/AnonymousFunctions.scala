package lectures.part3

object AnonymousFunctions extends App {

  val doubler = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  // same as the above in lambda form
  val doubler_lambda: (Int) => Int = (x: Int) => x * 2
  println(doubler(10))
  println(doubler_lambda(10))

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val adder2 = (a: Int, b: Int) => a + b // This also works
  println(adder(10, 10))
  println(adder2(10, 10))

  // No params
  val justDoSomething: () => Int = () => 3
  println(justDoSomething) // returns the function as stored in memory
  println(justDoSomething()) // returns true

  val stringToInt = { // you can also call lambdas with curly braces
    (str: String) => str.toInt
  }
  println(stringToInt("3"))

  // More syntactic sugar | The underscore will replace the params
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b


  val supperAdd = (x: Int) => (y: Int) => x + y
    println(supperAdd(3)(4))
}
