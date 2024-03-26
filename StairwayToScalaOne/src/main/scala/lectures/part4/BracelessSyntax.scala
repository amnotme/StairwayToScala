package lectures.part4

object BracelessSyntax  {

  // if - expressions
  val anIfExpressions = if (2 > 3) "bigger" else "smaller"

  // java - style
  val anIfExpression_v2 =
    if (2 > 3) {
      "bigger"
    } else {
      "smaller"
    }

  // compact
  val anIfExpression_v3 =
    if (2 > 3) "bigger"
    else "smaller"

  val anIfExpression_v4 =
    if 2 > 3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result

  val anIfExpression_v5 =
    if 2 > 3 then
      "bigger"
    else
      "smaller"

  val aforComprehension =
    for
      n <- List(1, 2, 3)
      s <- List("Black", "White")
    yield s"$n$s"


  // pattern matching

  val meaningOfLife = 42

  val aPatternMatch =
    meaningOfLife match
      case 1 => "The one"
      case 2 => "something else"
      case _ => "whatever"

  def computeMeaningOfLife(arg: Int): Int =
    val partialResult = 42
    partialResult * 2



  // class definition with significant indentation (same for traits, objects, enums etc)

  class Animal:
    def eat(): Unit =
      println("I'm eating")

    def grow(): Unit =
      println("I'm growing")

  end Animal // optional to signify that the method is finished



  def main(args: Array[String]): Unit = {
    println(anIfExpression_v4)
    println(anIfExpression_v5)
    println(aforComprehension)
    println(computeMeaningOfLife(2))
  }

}
