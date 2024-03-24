package lectures.part2

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("Cruch cruch")
  }
  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    override def eat: Unit = println("Nononon")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // Traits vs abstracts classes
  // 1 = traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits describe "behavior" / abstract class "blueprints / actions"
}
