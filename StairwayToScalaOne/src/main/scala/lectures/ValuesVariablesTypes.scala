package lectures

object ValuesVariablesTypes extends App {

  // VALS are immutable
  val x: Int  = 42
  println(42)

  val aString: String = "This is a string"
  println(aString)

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anint: Int = x
  val aShort: Short = 4616
  val aLong: Long = 1234123412341234L
  val aFloat: Float = 2.0f
  val aDouble: Double = 2.0

  // Variables are muttable

  var aVariable: Int = 4

  aVariable = 6

  println(aVariable)
}
