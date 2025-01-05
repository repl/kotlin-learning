package org.kotlinlang.play.scope

fun main() {
    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {                                                  // 1
            println("\tis empty? " + isEmpty())                    // 2
            println("\tlength = $length")
            length                                                 // 3
        }
    }

    //Like let, run is another scoping function from the standard library. Basically, it does the same:
    // executes a code block and returns its result. The difference is that inside run the object is accessed by this.
    // This is useful when you want to call the object's methods rather than pass it as an argument.
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with Kotlin")
}