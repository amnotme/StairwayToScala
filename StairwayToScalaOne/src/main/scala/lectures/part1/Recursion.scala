package lectures.part1

import scala.annotation.tailrec

object Recursion extends App {



  def anotherFactorial(num: Int): BigInt = {

    @tailrec
    def factorial(num: Int, acc: BigInt): BigInt = {
      if (num <= 1) acc
      else factorial(num - 1, acc * num) // Tail recursion
    }

    factorial(num, 1)
  }
//  println(anotherFactorial(5000))

  def concatString(aString: String, times: Int): String = {

    @tailrec
    def concatHelper(num: Int, acc: String): String = {
      if (num == 1) acc
      else concatHelper(num - 1, acc = acc + aString)
    }

    concatHelper(times, aString)
  }
  println(concatString("hello ", 5))

  def isPrime(num: Int): Boolean = {

    @tailrec
    def isPrimeHelper(inNum: Int, acc: Boolean): Boolean = {
      if (!acc) false
      else if (inNum <= 1) true
      else isPrimeHelper(inNum - 1, num % inNum != 0 && acc)
    }

    isPrimeHelper(num / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))


  def fibonnaci(num: Int): BigInt = {

    @tailrec
    def fibHelper(current: Int, prev: BigInt, next: BigInt): BigInt = {
      if (current >= num) next
      else fibHelper(current + 1, next, prev + next)
    }
    if (num <= 2) 1
    else fibHelper(2, 1, 1)
  }
  println(fibonnaci(8))
}
