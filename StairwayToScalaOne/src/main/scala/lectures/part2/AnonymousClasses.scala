package lectures.part2


object AnonymousClasses extends App {

  abstract class Animal {
    infix def eat: Unit
  }

  val funnyAnimal = new Animal: // This creates an anonymous class from abstract class Animal
    override infix def eat: Unit = println("hhahahaha")

  /*
  Equivalent to
  class AnonymousClasses$$anon$1 extends Animal {
    override indix def eat: Unit = println("hhahahaha")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(val name: String) {
    infix def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is $name, how can I be of service?")
  }
}
