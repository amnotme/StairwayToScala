package lectures

object Expressions extends App{

  val x = 1 + 2 // Expression
  println(x)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3

  println(aVariable)

  // Instructions (DO) vs Expressions (VALUES)

  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3

  println(aConditionValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //EVERYTHING in SCALA is an EXPRESSION

  val aWeirdExpression = (aVariable = 3)
  println(aWeirdExpression) // This prints a UNIT (void)
  // side effects: println(), whiles, reassigning

  // code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42 // a code black prints out the last thing in its block
  }
  println(someValue)
  println(someOtherValue)
}
