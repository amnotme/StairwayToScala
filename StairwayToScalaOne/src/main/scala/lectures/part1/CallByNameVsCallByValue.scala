package lectures.part1

object CallByNameVsCallByValue extends App {

  def calledByValue(x: Long): Unit = {
    println("By value:" + x)
    println("By value:" + x)
  }

  def calledByName(x: => Long): Unit = {
    println("By name:" + x)
    println("By name:" + x)
  }

  calledByValue(System.nanoTime()) // This will pass the value of what (System.nanoTime()) evaluates to
  calledByName(System.nanoTime()) // This will pass the expression due to the => syntax.  That means that (System.nanoTime()) evaluates every single time.
}
