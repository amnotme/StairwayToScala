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

  /*
  1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
  careful with overlapping keys
  2. Overly simplified social network based on maps
  Person = String
  - add a person to the network
  - remove
  - friend (mutual)
  - unfriend

  - number of friends of a person
  - person with most friends
  - how many people have NO friends
  - if there is a social connection between two people (direct or not)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Mary"), "Bob")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(remove(network, "Bob"))


  // Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
//    network.view.filterKeys(k => network(k).isEmpty).size OR
    network.count(pair => pair._2.isEmpty) // same as the above
//    network.count(_._2.isEmpty) // same as the above

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, considerePeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (considerePeople.contains(person)) bfs(target, considerePeople, discoveredPeople.tail)
        else bfs(target, considerePeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }
  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Jim"))
}
