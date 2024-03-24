package lectures.part2

object OOBasics extends App {
  val person = new Person("Leo", 20)
  println(person)
  println(person.age)
  println(person.x) // this will also get printed
  println(person.greet("David"))
}

// constructor
class Person(val name: String, val age: Int) {
  // body
  val x = 2

  // method
  def greet(name: String): Unit = println(s"${this.name} says hi, $name")

}
// class parameters are NOT FIELDS