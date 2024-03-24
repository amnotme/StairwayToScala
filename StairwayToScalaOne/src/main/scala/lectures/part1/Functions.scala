package lectures.part1

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  println(aRepeatedFunction("Hello", 10))
  // /When YOU NEED LOOPS, USE Recursion

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("hello")


  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }
  println(aBigFunction(20))



//   *  1. A greeting function (name, age) -> "Hi, my name is $name and I am $age years old.
//   *  2. Factorial function 1 * 2 * 3 * ... * n
//   *  3. A fibonacci function
//   *  4. Tests if a number is prime


  def greeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }
  println(greeting("leo", 32))

  def factorial(num: Int): Int = {
    if (num <= 0) 1
    else factorial(num - 1) * num
  }

  println(factorial(5))

  def fib(num: Int): Int =
    if (num <= 2) 1
    else fib(num - 1) + fib(num - 2)

  println(fib(8))

  def isPrime(num: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else num % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(num / 2)
  }

  println(isPrime(9))
  println(isPrime(120))
  println(isPrime(47))



}
