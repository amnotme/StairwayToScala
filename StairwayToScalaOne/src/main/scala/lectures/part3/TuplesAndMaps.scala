package lectures.part3

object TuplesAndMaps extends App {
  val aTuple = new Tuple2(2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)
  val aTupleShort = Tuple2(2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye java"))
  println(aTuple.swap) // ("Hello, Scala, 2)

  // Maps - Keys -> values
  val aMap: Map[String, Int] = Map()
  val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1) // this creates a default value so it doesn't crash
  // a -> b is sugar for (a, b)

  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("May")) // This crashes

  // Add a paring
  val newParing = "Mary" -> 678
  val newPhoneBook = phoneBook + newParing
  println(newPhoneBook)

  // functional on maps
  // map, flatMap, filter
  println(phoneBook.map(pair => pair._1.toUpperCase -> pair._2))
  // filterKeys
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap)
  // mapValues
  println(phoneBook.view.mapValues(number => s"0245-$number").toMap)
  // conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
