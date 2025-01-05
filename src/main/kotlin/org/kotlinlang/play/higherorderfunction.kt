package org.kotlinlang.play

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

fun sumOp(x: Int, y: Int) = x + y                                     // 3

fun operation(): (Int) -> Int {                                     // 1
    return ::square
}

fun square(x: Int) = x * x                                          // 2

fun main() {
    val sumResult = calculate(4, 5, ::sumOp)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    println("sumResult $sumResult, mulResult $mulResult")

    // Returning functions
    val func = operation()                                          // 3
    println(func(2))                                                // 4

}