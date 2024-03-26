# StairwayToScala

Welcome to StairwayToScala, a comprehensive Scala learning repository designed for developers looking to enhance their Scala programming skills. From basic syntax to advanced features, this repository aims to provide a structured pathway for mastering Scala.

### Overview

StairwayToScala is structured to facilitate a step-by-step learning approach, covering various aspects of the Scala programming language. The repository is divided into sections, each focusing on different Scala concepts and features.

### Contents:

#### Part 1: Basics of Scala

* Introduction to Scala
* Setting up the Scala environment
* Basic syntax and operations
* Control structures and loops

#### Part 2: Functional Programming in Scala

* Understanding functional programming concepts
* Functions and higher-order functions
* Collections and their operations
* Pattern matching and options

#### Part 3: Object-Oriented Programming in Scala

* Classes and objects
* Traits and abstract classes
* Inheritance and composition
* Case classes and pattern matching

#### Part 4: Advanced Scala Concepts

* Implicit values and conversions
* Generics and type parameters
* Concurrency and Future
* Type classes and more advanced patterns


## Examples of map, filter, and flatMap in Scala 3

This section provides examples illustrating how to use map, filter, and flatMap methods in Scala 3. These methods are crucial for working with collections and other container types, such as Option, enabling functional and concise code.

#### map

The map function applies a given function to each element of a collection, returning a new collection of the results.

```scala 3
val numbers = List(1, 2, 3, 4, 5)
val squaredNumbers = numbers.map(n => n * n) // Squaring each number
println(squaredNumbers) // Output: List(1, 4, 9, 16, 25)
```

#### filter

The filter function removes elements that do not satisfy a specified condition.

```scala 3
val numbers = List(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter(n => n % 2 == 0) // Keeping only even numbers
println(evenNumbers) // Output: List(2, 4)
```

#### flatMap

The flatMap function applies a function that returns a collection for each element, then flattens the result into a single collection.

```scala 3
val words = List("Hello", "World", "Scala", "Programming")
val characters = words.flatMap(word => word.toList) // Converting each word to a list of characters
println(characters) // Output: List(H, e, l, l, o, W, o, r, l, d, S, c, a, l, a, P, r, o, g, r, a, m, m, i, n, g)
```
These examples demonstrate basic usages of map, filter, and flatMap on Scala collections. They can serve as a foundation for more complex operations and functional programming techniques in Scala.

## Chaining map, filter, and flatMap in Scala 3

In functional programming, it is common to chain multiple operations to perform complex data processing in a readable and concise way. Here are some examples using Scala 3:

#### Chaining map and filter

You can chain map and filter to transform and then filter a collection:


```scala 3
val numbers = List(1, 2, 3, 4, 5)
val squaredEvenNumbers = numbers.map(n => n * n).filter(squared => squared % 2 == 0)
println(squaredEvenNumbers) // Output: List(4, 16)
```
This example first squares each number in the list, then filters out the squared numbers that are not even.

#### Chaining flatMap and map

flatMap can be used with map to flatten and then map a collection:

```scala 3
val phrases = List("Hello world", "Scala programming", "Functional programming")
val wordLengths = phrases.flatMap(phrase => phrase.split(" ")).map(word => word.length)
println(wordLengths) // Output: List(5, 5, 5, 11, 10, 11)
```
This example first splits each phrase into words, resulting in a list of lists. Then flatMap flattens it into a single list of words, and map is used to transform each word into its length.

#### Comprehensive Example with map, filter, and flatMap

Combining map, filter, and flatMap together for more complex transformations:


```scala 3
val sentences = List("Hello world and Scala", "The joy of Scala programming", "Understanding functional programming")
val filteredWordsLengths = sentences
  .flatMap(sentence => sentence.split(" ")) // Splitting each sentence into words
  .filter(word => word.startsWith("S") || word.startsWith("F")) // Filtering words that start with 'S' or 'F'
  .map(word => word.length) // Mapping each word to its length
println(filteredWordsLengths) // Output: List(5, 6, 8)
```
In this comprehensive example, the sentences are first split into words, then words starting with 'S' or 'F' are filtered, and finally, the length of each remaining word is calculated.

