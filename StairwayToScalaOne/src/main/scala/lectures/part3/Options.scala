package lectures.part3

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  def unsafeMethod(): String = null
  val result = Option(unsafeMethod())

  println(result)

  // chained methods
  def backupMethod(): String = "A vaild result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Design unsafe API

  def betterUnsafeMethod(): Option[String] = None
  def betterBackUpMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackUpMethod()

  println(betterChainedResult)

  // functions as Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE - DO NOT USE THIS

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  /*
   */
  val config: Map[String, String] = Map (
    // fetched from else-where
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method

  val host = config.get("host")
  val port = config.get("port")

  /*
  if (c != null)
    if (p != null)
      return Connection.apply(h, p)
  return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
  if (c != null)
    return c.connect
  return null
   */
  val connectionStatus = connection.map(_.connect)
  // if (connectionStatus == null) println(None) else print (Some(connectionsStatus.get))
  println(connectionStatus)
  /*
  if (status != null)
    println(status)
   */
  connectionStatus.foreach(println)

  val connectionFor: Option[Connection] = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatusFor: Option[String] = connectionFor.map(x => x.connect)

  println(connectionStatusFor)
}
