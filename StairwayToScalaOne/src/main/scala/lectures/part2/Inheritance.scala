package lectures.part2

import scala.language.postfixOps

object Inheritance extends App {

  class Animal {
    val creatureType = "wild"
    protected infix def eat : Unit = println("nonom")
  }

  class Cat extends Animal {
    infix def cruch: Unit = {
      eat
      println("Cruch cruch")
    }
  }

  val cat = new Cat

  cat cruch

  class Person(name: String, age: Int) {
    def this(name: String) = this (name, 0) // auxilary constructors are possible
  }
  class Adult(name: String, age: Int, idCard: String) extends  Person(name, age)
  class Adult2(name: String, age: Int, idCard: String) extends  Person(name) // using the Auxilary Constructor

  class Dog(override val creatureType: String = "Domesticated") extends Animal {
//    override val creatureType: String = "Domesticated"
    override infix def eat : Unit =  {
      // Super. Calls parent method
      super.eat
      println("Crunch, cruch")
    }
  }

  val dog = new Dog
  dog eat

  println(dog.creatureType)

  val unknownAnimal = new Dog("k9")
  unknownAnimal.eat

  // preventing overrides
  // use final on memeber
  // use final on the entire class
  // use seal on the class
}
