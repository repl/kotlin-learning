package org.kotlinlang.play.scope

fun main() {
    val jake = Person()                                     // 1
    val stringDescription = jake.apply {                    // 2
        name = "Jake"                                       // 3
        age = 30
        about = "Android developer"
    }.toString()
    // apply executes a block of code on an object and returns the object itself. Inside the block, the object is referenced by this. This function is handy for initializing objects.
}

data class Person(var name: String? = null, var age: Int? = null, var about: String? = null)