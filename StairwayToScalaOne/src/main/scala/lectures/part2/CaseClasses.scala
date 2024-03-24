package lectures.part2

object CaseClasses extends App {
  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. Class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion object
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns == CCs can be used in Pattern matching
  case object UnitedKindom {
    def name : String = "The UK"
  }

}
