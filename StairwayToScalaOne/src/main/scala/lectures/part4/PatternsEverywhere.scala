package lectures.part4

object PatternsEverywhere extends App {

  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "Something else"
  }

  // catches are actually Matches

  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // ?
  } yield 10 * x

  println(evenOnes)

  // generators are also based on Pattern matching
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  // case classes, :: operators, ...

  // bid idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)

  // multiple value definitions based on Pattern matching
  // all the power

  val head :: tail = list
  println(head)
  println(tail)

  // big idea # 4 - NEW
  // partial function
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "Something else"
  }

  val mappedList2 = list.map( x => x match {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "Something else"
  })
}
