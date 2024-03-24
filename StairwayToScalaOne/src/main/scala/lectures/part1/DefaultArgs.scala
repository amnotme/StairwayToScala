package lectures.part1

import scala.annotation.tailrec

object DefaultArgs extends App {

    @tailrec
    def trFact(n: Int, acc: Int = 1): Int = {
      if (n <= 1) acc
      else trFact(n - 1, n * acc)
    }

    val fact10 = trFact(10, acc = 2) // We can use default named values just like python
    println(fact10)
}
