package org.kotlinlang.play.scope

fun main() {
    val jake = Person("Jake", 30, "Android developer")   // 1
        .also {                                          // 2
            writeCreationLog(it)                         // 3
        }
}

fun writeCreationLog(it: Person) {

}
