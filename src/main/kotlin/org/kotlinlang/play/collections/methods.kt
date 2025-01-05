package org.kotlinlang.play.collections

import kotlin.math.abs

fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)      // 1

    val positives = numbers.filter { x -> x > 0 }  // 2

    val negatives = numbers.filter { it < 0 }      // 3

    val doubled = numbers.map { x -> x * 2 }      // 2

    val tripled = numbers.map { it * 3 }          // 3

    val anyNegative = numbers.any { it < 0 }             // 2

    val anyGT6 = numbers.any { it > 6 }                  // 3

    val allEven = numbers.all { it % 2 == 0 }            // 2

    val allLess6 = numbers.all { it < 6 }                // 3

    val noneEven = numbers.none { it % 2 == 1 }           // 2

    val noneGt6 = numbers.none { it > 6 }               // 3

    println(numbers.filter { it % 2 == 0 }.joinToString(" ") { it.toString() })

    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")  // 1

    val first = words.find { it.startsWith("some") }                                // 2
    val last = words.findLast { it.startsWith("some") }                             // 3

    val nothing = words.find { it.contains("nothing") }                             // 4

    val first1 = numbers.first()                          // 2
    val last1 = numbers.last()                            // 3

    val firstEven = numbers.first { it % 2 == 0 }        // same as find
    val lastOdd = numbers.last { it % 2 != 0 }           // same as findLast

    val words2 = listOf("foo", "bar", "baz", "faz")         // 1
    val empty = emptyList<String>()                        // 2

    val firstOrNull = empty.firstOrNull()                        // 3
    val lastOrNull = empty.lastOrNull()                          // 4

    val firstF = words2.firstOrNull { it.startsWith('f') }  // 5
    val firstZ = words2.firstOrNull { it.startsWith('z') }  // 6
    val lastF = words2.lastOrNull { it.endsWith('f') }      // 7
    val lastZ = words2.lastOrNull { it.endsWith('z') }      // 8


    val totalCount = numbers.count()                     // 2
    val evenCount = numbers.count { it % 2 == 0 }        // 3


    data class Person(val name: String, val city: String, val phone: String) // 1

    val people = listOf(                                                     // 2
        Person("John", "Boston", "+1-888-123456"),
        Person("Sarah", "Munich", "+49-777-789123"),
        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

    // Functions associateBy and groupBy build maps from the elements of a collection indexed by the specified key.
    // The key is defined in the keySelector parameter. You can also specify an optional valueSelector to define what will be stored in the value of the map element.

    val phoneBook = people.associateBy { it.phone }                          // 3
    val cityBook = people.associateBy(Person::phone, Person::city)           // 4
    val peopleCities = people.groupBy(Person::city, Person::name)            // 5
    val lastPersonCity = people.associateBy(Person::city, Person::name)      // 6

    val evenOdd = numbers.partition { it % 2 == 0 }           // 2
    val (posNums, negNums) = numbers.partition { it > 0 } // 3

    val fruitsBag = listOf("apple","orange","banana","grapes")  // 1
    val clothesBag = listOf("shirts","pants","jeans")           // 2
    val cart = listOf(fruitsBag, clothesBag)                    // 3
    val mapBag = cart.map { it }                                // list of two lists.
    val flatMapBag = cart.flatMap { it }                        // single list consisting of elements from both lists.

    val numbs = listOf(1, 2, 3)
    val only = listOf(3)

    println("Numbers: $numbs, min = ${numbs.minOrNull()} max = ${numbs.maxOrNull()}") // 1
    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}")        // 2
    println("Only: $only, min = ${only.minOrNull()}, max = ${only.maxOrNull()}")            // 3

    val shuffled = listOf(5, 4, 2, 1, 3, -10)                   // 1
    val natural = shuffled.sorted()                             // 2
    val inverted = shuffled.sortedBy { -it }                    // Sorts it in the inverted natural order by using -it as a selector function.
    val descending = shuffled.sortedDescending()                // Sorts it in the inverted natural order by using sortedDescending.
    val descendingBy = shuffled.sortedByDescending { abs(it)  } // Sorts it in the inverted natural order of items' absolute values by using abs(it) as a selector function.


    val map = mapOf("key" to 42)

    val value1 = map["key"]                                     // 1
    val value2 = map["key2"]                                    // 2

    val value3: Int = map.getValue("key")                       // 1

    val mapWithDefault = map.withDefault { k -> k.length }
    val value4 = mapWithDefault.getValue("key2")                // Returns the default value because "key2" is absent. For this key it's 4.

    try {
        map.getValue("anotherKey")                              // 4
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }

    val A = listOf("a", "b", "c")                  // 1
    val B = listOf(1, 2, 3, 4)                     // 1

    val resultPairs = A zip B                      // Merges them into a list of pairs of source collection elements with the same index.. The infix notation is used here.
    val resultReduce = A.zip(B) { a, b -> "$a$b" } // Merges them into a list of String values by the given transformation.

    val list = listOf(0, 10, 20)
    println(list.getOrElse(1) { 42 })    // 1
    println(list.getOrElse(10) { 42 })   // 2

    val map1 = mutableMapOf<String, Int?>()
    println(map1.getOrElse("x") { 1 })       // 1

    map1["x"] = 3
    println(map1.getOrElse("x") { 1 })       // 2

    map1["x"] = null
    println(map1.getOrElse("x") { 1 })       // 3


}