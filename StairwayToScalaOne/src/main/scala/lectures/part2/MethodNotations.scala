package lectures.part2

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangsOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    // Task 1

    def +(str: String): Person = new Person(s"${this.name} ($str)", this.favoriteMovie)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    infix def learns(str: String): String = s"${this.name} learns $str"
    def learnsScala: String = this learns "Scala"
    def apply(numTimes: Int): String = s"${this.name} watched ${this.favoriteMovie} $numTimes times"
  }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))
    println(mary `likes` "Inception") // equivalent as the above
    // infix notation = operator notation

    val tom = new Person("Tom", "Fight Club")
    println(mary `hangsOutWith` tom)

    println(1 + 2)
    println(1.+(2)) // equivalent
    // ALL operators are methods

    // prefix notation
    val x = -1
    val y = 1.unary_-

    println(!mary)
    println(mary.unary_!) // equivalent due to the method

    println(mary.isAlive)
    println(mary isAlive)

    // apply
    println(mary.apply())
    println(mary()) // equivalent


    /*
      1. Overload the + operator
      mary + "the rockstar" => New person "Mary (the rockstar")

      2. Add an age to the Person class
         Add a unary + operator => new person with the age + 1
        +mary => mary witht he age incrementer
      3. Add a "learns" method in the Person class => "Mary learns Scala"
         Add a learnsScala method, calls learns method with "Scala".
         Use it in postfix notation
      4. Overload the apply method
        mary.apply(2) => "Mary watched inception 2 times"
     */

    println((mary + "the rockstar")())
    println((+mary).age)
    println(mary learnsScala)
    println(mary(2))
}
