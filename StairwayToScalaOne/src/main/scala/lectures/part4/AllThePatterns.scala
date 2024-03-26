package lectures.part4

object AllThePatterns extends App {
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "A number"
    case "Scala" => "THe SCala"
    case true => "THe truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 Wildcard

  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - Tuples
  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"

  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  // PMS can be NESTED!


  val aList = List(1, 2, 3, 42)
  val standardLlistMatching = aList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => // infix pattern
  }

  // 6 type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 8 Multi- patterns
//  val multiPattern = aList match {
//    case Empty | Cons(0, _) =>
//  }

  // 9 if guards
//  val secondElementSpecial = aList match {
//    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
//  }

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""

  println(numbersMatch) // type erasure
}
