package me.zhang.kotlin

import java.util.*

/**
 * Created by Zhang on 12/24/2017 2:28 PM.
 */
fun main(args: Array<String>) {
    labels()
}

fun labels() {
    labelsInForLoop()
    println()

    returnAtLabels()
}

private fun labelsInForLoop() {
    loop@ for (i in 1..100) {
        if (i == 100) return@loop
        if (i == 99) break@loop
        if (i % 2 == 0) continue@loop
        print("$i ")
    }
}

private fun returnAtLabels() {
    val arrayOfAlphabet = arrayOf("A", "B", "C", "D")

    arrayOfAlphabet.forEach c@ {
        if (it == "C") return@c // it returns only from the lambda expression
        print("$it ")
    }
    println()

    arrayOfAlphabet.forEach {
        // implicits labels: such a label has the same name as the function to which the lambda is passed
        if (it == "D") return@forEach
        print("$it ")
    }
    println()

    arrayOfAlphabet.forEach(fun(value: String) {
        if (value == "B") return // local return to the caller of the anonymous fun, i.e. the forEach loop
        print("$value ")
    })
    println()

    arrayOfAlphabet.forEach {
        // The return-expression returns from the nearest enclosing function
        if (it == "C") return // nonlocal return from inside lambda directly to the caller of returnAtLabels()
        print("$it ")
    }
    println()
}

fun returnsAndJumps() {
    val supplies = arrayOf("Book", "Pen", null, "Eraser", null)
    for (supply in supplies) {
        print("${supply ?: continue} ") // only print none null supplies
    }
    println()

    println(getSupplyByFirstAlphabet("E", supplies))
    println(getSupplyByFirstAlphabet("K", supplies))

    println(supplies.firstOrNull { it?.startsWith("P") == true })
    println(supplies.firstOrNull { it?.startsWith("M") == true })
}

private fun getSupplyByFirstAlphabet(firstAlphabet: String, supplies: Array<String?>): String? {
    loop@ for (supply in supplies) {
        if (supply?.startsWith(firstAlphabet) == true) {
            return@loop supply // gives preference to the qualified return
        }
    }
    return null
}

fun controlFlow() {
    println("******* if statement *******")
    ifStatement()

    println("******* when statement *******")
    whenStatement()

    println("******* loop statement *******")
    loopStatement()
}

fun ifStatement() {
    println(traditional(1, 2))
    println(withElse(3, 4))
    println(asExpression(6, 5))
}

private fun traditional(a: Int, b: Int): Int {
    var max = a
    if (a < b) max = b
    return max
}

private fun withElse(a: Int, b: Int): Int {
    var max: Int
    if (a < b) {
        max = b
    } else {
        max = a
    }
    return max
}

private fun asExpression(a: Int, b: Int): Int {
    var max = if (a < b) {
        print("Choose b: ")
        b // the last expression is the value of a block
    } else {
        print("Choose a: ")
        a
    }
    return max
}

fun whenStatement() {
    println("** when as statement")
    whenAsStatement(1)
    whenAsStatement(2)
    val case3 = 3
    try {
        whenAsStatement(case3)
    } catch (exp: IllegalArgumentException) {
        println("${exp.message}: $case3")
    }
    whenAsStatement(4, "4") // parseInt("4") == 4

    println("** when as expression")
    println(whenAsExpression(1))
    println(whenAsExpression(2))
    println(whenAsExpression(4))
    try {
        println(whenAsExpression(10))
    } catch (e: IllegalArgumentException) {
        println("Exception occurs, case: ${10}")
    }
    println(whenAsExpression(9))
    println(whenAsExpression(21))

    var s = "prefixM"
    println("$s has prefix: ${hasPrefix(s)}")
    s = "mSuffix"
    println("$s has prefix: ${hasPrefix(s)}")

    whenAsIf(2)
    whenAsIf(11)
    whenAsIf(1.5f)
}

private fun whenAsStatement(case: Int, str: String = "") {
    when (case) {
        1 -> println("case is 1")
        2 -> println("case is 2")
        parseInt(str) -> println("str encodes case")
        else ->
            throw IllegalArgumentException("unknown case")
    }
}

private fun whenAsExpression(case: Int): String {
    return when (case) {
        1 -> "case is 1"
        2 -> "case is 2"
        3, 4, 5 -> "case is one of 3, 4, 5"
        in 7..9 -> "case is in 7, 8, 9"
        !in 10..20 -> "case is not in 10..20"
        else ->
            throw IllegalArgumentException("unknown case")
    }
}

private fun hasPrefix(s: Any) = when (s) {
    is String -> s.startsWith("prefix")
    else -> false
}

private fun whenAsIf(x: Number) {
    when {
        x.isEven() -> println("x is even")
        x.isOdd() -> println("x is odd")
        else -> println("x is funny")
    }
}

private fun Number.isOdd() = if (this is Int) Math.abs(this % 2) == 1 else false

private fun Number.isEven() = when {
    this is Int -> this % 2 == 0
    else -> false
}

fun loopStatement() {
    val courses = arrayOf("Chinese", "English", "Math", "Geometry", "Physics")
    for (course in courses) {
        if (course.startsWith("C")) {
            continue
        }
        print("$course ")
    }
    println()
    for (i in courses.indices) {
        print("${courses[i]} ")
    }
    println()

    for ((i, value) in courses.withIndex()) {
        print("$i->$value ")
    }
    println()

    var index = 0
    while (index < courses.size) {
        print("${courses[index]} ")
        index++
    }
    println()

    index = 0
    do {
        print("${courses[index]} ")
        if (index == 2) break
        index++
    } while (index < courses.size)
    println()
}

fun strings() {
    // escaped string
    val string = "In computer programming, a string is traditionally a sequence of characters."
    for (s in string) { // iterate a string
        print(s)
    }
    println("\n***********")

    // raw string
    val code = """
        for (s in string)
            print(s)
        """
    print(code)
    println("\n***********")

    val command = """
        >
        >javac Hello.java
        >java Hello
        >
        """
    print(command.trimMargin(">"))
    println("\n***********")

    val intArrayOf = intArrayOf(1, 2, 3, 4, 5)
    intArrayOf.forEach { print("i=$it ") }
    println("\n***********")

    val s = "Hello Kotlin!"
    print("\"$s\".length is ${s.length}")
    println("\n***********")

    val mount = 1200
    val price = """
        ${'$'}$mount
        """
    print(price)
    println("\n***********")
}

fun arrays() {
    val arrayOfInts = arrayOf(1, 2, 3)
    arrayOfInts.forEach { print("$it ") }
    println("\n***********")

    val arrayOfStrings = arrayOfNulls<String>(5)
    for ((index, i) in (1..4).withIndex()) {
        arrayOfStrings[index] = "${i + 10}"
    }
    arrayOfStrings.filter { it != null }
            .map { it?.replace("1", "x") }
            .forEach { print("$it ") }
    println("\n***********")

    val asc = Array(5, { i -> (i * i).toString() })
    asc.forEach { print(it + " ") }
    println("\n***********")
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