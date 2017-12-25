package me.zhang.kotlin

import java.util.*

/**
 * Created by Zhang on 12/24/2017 2:28 PM.
 */
fun main(args: Array<String>) {
    println("Hello World!")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun minus(a: Int, b: Int) = a - b

/* /* Unlike Java, block comments in Kotlin can be nested. */ */
var x = 0

fun incrementX() {
    x += 1
}

fun stringTemplate() {
    var a = 1
    val s1 = "a is $a"
    println(s1)

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

fun maxOf(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun minOf(a: Int, b: Int) = if (a > b) b else a

fun parseInt(n: String): Int? {
    return n.toIntOrNull()
}

fun calcProduct(x: String, y: String): Int? {
    val a = parseInt(x)
    val b = parseInt(y)

    return if (a != null && b != null) {
        a * b
    } else {
        null
    }
}

fun getStringLength(o: Any): Int? {
    if (o is String) {
        return o.length // 'o' is automatically cast to 'String'
    }
    // 'o' is not a 'String'
    return null
}

fun loopAll(list: List<String>) {
    for (item in list) {
        println(item)
    }
    for (index in list.indices) {
        println("(for)item at $index is ${list[index]}")
    }
    var index = 0
    while (index < list.size) {
        println("(while)item at $index is ${list[index]}")
        index++
    }
}

fun describe(o: Any): String = when (o) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a string"
    else -> "Unknown"
}

fun range() {
    for (i in 1..10 step 2) {
        println(i)
    }

    val m = -1
    if (m !in 0..3) {
        println("$m not in 0, 1, 3")
    }

    for (x in 9 downTo 0 step 3) {
        println(x)
    }
}

fun lambda() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.substring(0, 1).toUpperCase() + it.substring(1) }
            .forEach { println(it) }
}

fun obj() {
    val list = ArrayList<String>() // no 'new' keyword required
    list.add("M")
    list.add("N")
    list.add("O")
    for (it in list) {
        println(it)
    }
}

fun notNullShorthand() {
    val fruit = Arrays.asList("Apple", null, "Banana", "Orange", null)
    println("********If not null shorthand********")
    for (f in fruit) {
        println(f?.length)
    }

    println("********If not null and else shorthand********")
    for (f in fruit) {
        println(f?.length ?: "item is null")
    }

    println("********Executing a statement if null********")
    for (f in fruit) {
        println(f?.length ?: continue)
    }

    println("********Execute if not null********")
    for (f in fruit) {
        f?.let { println(f) }
    }

    println("********Map nullable value if not null\n********")
    for (f in fruit) {
        println(f?.let { f.toLowerCase() } ?: "*** no fruit ***")
    }
}

fun transform(color: String): Int = when (color.toUpperCase()) {
    "RED" -> 0
    "GREEN" -> 1
    "BLUE" -> 2
    else -> throw IllegalArgumentException("Invalid color string")
}

fun divide(x: Int, y: Int): Int {
    return try {
        x / y
    } catch (e: ArithmeticException) {
        throw ArithmeticException("$x / $y : " + e.message)
    }
}