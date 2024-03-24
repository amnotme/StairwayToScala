package lectures.part2

object OOBasics extends App {
  val person = new Person("Leo", 20)
  println(person)
  println(person.age)
  println(person.x) // this will also get printed
  person.greet("David")
  person.greet()


  // OOBasics Two

  val author = new Writer("Leo", "Hernandez", 1994)
  val authorImposter = new Writer("Leo", "Hernandez", 1994)
  val novel = new Novel("Great", 2012, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author)) // true
  println(novel.isWrittenBy(authorImposter)) // false

  val counter = new Counter(0)
  counter.incrementCounter().print()
  counter.incrementCounter().incrementCounter().incrementCounter().print()
  counter.incrementCounter(10).print()
}

// constructor
class Person(val name: String, val age: Int) {
  // body
  val x = 2
  // method
  def greet(name: String): Unit = println(s"${this.name} says hi, $name")
  // overloading
  def greet(): Unit = println(s"Hi, I'm $name")
  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe") // not really useful.

}

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName(): String = s"$firstName $surName"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = yearOfRelease - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(yearOfRelease: Int): Novel = new Novel(name, yearOfRelease, author)
}

class Counter(count: Int) {

  def currentCount(): Int = count

  def incrementCounter(): Counter = {
    println("Incrementing")
    new Counter(count + 1)
  }
  def decrementCounter(): Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def incrementCounter(newCounter: Int): Counter =  {
    if (newCounter <= 0) this
    else incrementCounter().incrementCounter(newCounter - 1)
  }

  def decrementCounter(newCounter: Int): Counter =  {
    if (newCounter <= 0) this
    else decrementCounter().decrementCounter(newCounter - 1)
  }

  def print(): Unit = println(currentCount())
}

// class parameters are NOT FIELDS