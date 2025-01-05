package org.kotlinlang.play.scope

fun main() {
    val configuration = Configuration("localhost", 8080)
    with(configuration) {
        println("$host:$port")
    }

// instead of:
    println("${configuration.host}:${configuration.port}")
}

data class Configuration(val host: String, val port: Int)