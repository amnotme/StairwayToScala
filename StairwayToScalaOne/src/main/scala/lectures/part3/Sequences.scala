package lectures.part3

import scala.util.Random

object Sequences extends App {
  // Seq
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(1, 2, 3))
  println(aSequence.sorted)

  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 8).foreach(n =>
    if (n % 2 == 0) println(n)
  )

  // List

  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 89
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  // arrays

  var numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements.mkString)
  threeElements.foreach(println)

  numbers(2) = 43
  println(numbers.mkString(" "))

  // Arrays and Seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // Vectors

  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  val maxRuns = 100
  val maxCapacity = 10000
  // Vector vs Lists
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail +
  // updating an element in the middle takes long -
  println(getWriteTime(numbersList))
  // depth of the tree is small +
  // needs to replace an entire 32-element chunk -
  println(getWriteTime(numbersVector))


}
