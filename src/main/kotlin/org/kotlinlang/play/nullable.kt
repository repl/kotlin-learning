package org.kotlinlang.play

fun main() {
    println(describeString(""))
    println(describeString(null))
    println(describeString("abc"))
}

fun describeString(maybeString: String?): String {
//    return maybeString?.let {
//        if ( maybeString.isNotEmpty()) {
//            "String of length ${maybeString.length}"
//        } else {
//            "Empty or null string"
//        }
//    }?: "Empty or null string"
    return if (!maybeString.isNullOrEmpty()) {        // 2
        "String of length ${maybeString.length}"
    } else {
        "Empty or null string"                           // 3
    }
}