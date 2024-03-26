package lectures.part4

import scala.util.Random

object PatternMatching extends App {
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {

    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // "wildcard" default
  }
  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)
  val jon = Person("Jon", 24)
  val people: List[Person] = List(bob, jon)

  people.map(x => x match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I am $a years old and I can't drink"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }).foreach(println)


  people.map { // anonymous match. Equivalent to the above
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I am $a years old and I can't drink"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case null => "I don't know who I am"
  }.foreach(println)

  /*
  1. cases are matched in order
  2. what if no cases match? MatchError
  3. type of the PM expression? unified type of all the types in all the cases
  4. PM works really well with case classes
   */

  // PM on sealed hierarchies

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("terra nova")

  animal match {
    case Dog(somebreed) => println(s"Matched a dog of the $somebreed breed")
  }

  /*
  Exercise
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e: Expr, e2: Expr) extends Expr
  case class Prod(e: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))
}
