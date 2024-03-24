package lectures.part2

import playground.{Cinderella => Princess, PrinceCharming}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = Writer("jon", "what", 1111)

  // import the package by using "import" and then the package name.
  val princess = playground.Cinderella() // you can also use a fully qualified name
  val princessAlias = Princess() // using an alias

  // packages are in hierarchy
  // matching folder structure

  // package object... come from part2.package object

  sayHello
  println(SPEED)
  //imports
  val prince = new PrinceCharming

}
