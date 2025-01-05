package org.kotlinlang.play

open class Dog {                // 1
    open fun sayHello() {       // 2
        println("wow wow!")
    }
}

class Yorkshire : Dog() {       // 3
    override fun sayHello() {   // 4
        println("wif wif!")
    }
}

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India")


fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()

    val lion: Lion = Asiatic("Rufo")                              // 2
    lion.sayHello()

}