package lectures.part2

object Objects extends App {


  object Person {
    // Singleton pattern
    val N_EYES: Int = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  // SCALA DOES NOT HAVE CLASS-LEVEL Functionality ("Static")
  class Person(val name: String) {
    // Instance-level functionality
  }

  // COMPANIONS
  println(Person.N_EYES)
  println(Person.canFly)

  val mary = new Person("Mary")
  val jon = new Person("Jon")

  val bobby = Person(mary, jon) // This uses the apply method (Factory method)
}
