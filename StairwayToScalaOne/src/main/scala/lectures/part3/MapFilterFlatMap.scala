package lectures.part3

object MapFilterFlatMap extends App {
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("white", "black")

  // iterating
  val comb = colors.flatMap(
    col => chars.flatMap(
      c => numbers.filter(n => n % 2 == 0).map(
        num => s"$c$col$num"
      )
    )
  )
  println(comb)

  list.foreach(println)

  val forCombinations = for {
    col <- colors
    c <- chars
    num <- numbers if num  % 2 == 0
  } yield (s"$c$col$num")

  println(forCombinations)

  for { n <- numbers } print(s"$n ")
}
