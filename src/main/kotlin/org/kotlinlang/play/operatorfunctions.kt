package org.kotlinlang.play

fun main() {
    // https://kotlinlang.org/docs/operator-overloading.html

    operator fun Int.times(str: String) = str.repeat(this)       // 1
    println(2 * "Bye ")                                          // 2

    operator fun String.get(range: IntRange) = substring(range)  // 3
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])

    val v = listOf("a", "b")
    println("1" in v)
}
