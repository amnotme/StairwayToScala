package lectures.part3

import scala.util.{Failure, Random, Success, Try}


object HandlingFailure extends App {
  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super Failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String for you")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // If you design api
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid Result")

  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  println(betterFallback)

  // map, flatMap, filter

  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))


  // Exercise
  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }
    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // if you get the html page from the connection, print it to the console i.e. call renderHTML

  // 1. possible way one
  // Wrap them with a Try() getConnection and Connection.get then call foreach to render theHTML
  val getHttpServiceConnection = {
    Try(HttpService.getConnection(hostname, port)).flatMap(connection => Try(connection.get("somePge")))
  }
  getHttpServiceConnection.foreach(renderHTML)

  // 2. possible way two
  // Create safe methods in the api getSafe and getSafeConnection
  val getSafeHttpServiceConnection = HttpService.getSafeConnection(hostname, port)
  val getSafeConnection = getSafeHttpServiceConnection.flatMap(connection => connection.getSafe("SomePage"))
  getSafeConnection.foreach(renderHTML)

  // 3. possible way three
  // Chain everything
  Try(HttpService.getConnection(hostname, port))
    .flatMap(connection => Try(connection.get("SomeUrl")))
    .foreach(renderHTML)

  // 4 using for comprehensions

  for {
    connection <- Try(HttpService.getConnection(hostname, port))
    safeUrl <- Try(connection.get("SomeUrl"))
  } renderHTML(safeUrl)
}
