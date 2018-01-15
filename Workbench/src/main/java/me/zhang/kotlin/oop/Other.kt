package me.zhang.kotlin.oop

/**
 * Created by zhangxiangdong on 2018/1/13.
 */
fun main(args: Array<String>) {
    testOperatorOverloading()
}

fun testOperatorOverloading() {
    val a = 3
    println(a.unaryPlus()) // 3
    println(a.unaryMinus()) // -3

    val b = false
    println(b.not())
    println(!b)

    println("*****************")
    var c = 1
    println(c) // 1
    println(c.inc()) // 2
    println(c) // 1

    println(c.dec()) // 0
    println(c) // 1

    println(++c) // 2

    println("*****************")
    val point = Point(12f, 23f)
    println(point) // (12.0, 23.0)
    val mPoint = point.unaryMinus()
    println(mPoint) // (-12.0, -23.0)
    val pPoint = mPoint.unaryPlus()
    println(pPoint) // (12.0, 23.0)

    println(-point) // (-12.0, -23.0)

    println("*****************")
    println(Number(3).plus(5)) // 8
    println(Number(3) + 5) // 8
    val number = Number(3)
    number += 5
    println(number) // 8

    println("*****************")
    val strings = arrayListOf("A", "b", "C")
    val firstStr = strings[0] // strings.get(0)
    println(firstStr)
    println(strings.get(0))

    println("*****************")
    val intsMap = mutableMapOf(Pair("12", 2), Pair("34", 4), Pair("56", 6))
    val processor = MapProcessor(intsMap)
    println(processor[1, 2]) // 2
    processor[1, 2] = 3
    println(processor[1, 2]) // 3

    println("*****************")

}

class MapProcessor(val map: MutableMap<String, Int>) {

    operator fun get(k1: Int, k2: Int): Int? {
        val key = "$k1$k2"
        return map[key]
    }

    operator fun set(k1: Int, k2: Int, value: Int) {
        val key = "$k1$k2"
        map[key] = value
    }

}

data class Number(var value: Int) {

    operator fun plus(inc: Int): Number {
        return Number(inc + value)
    }

    operator fun plusAssign(inc: Int) {
        this.value = this.value + inc
    }

    override fun toString(): String {
        return "$value"
    }

}

operator fun Point.unaryMinus(): Point = Point(-x, -y)
operator fun Point.unaryPlus(): Point = Point(Math.abs(x), Math.abs(y))

data class Point(val x: Float, val y: Float) {
    override fun toString(): String {
        return "($x, $y)"
    }
}

fun testEquality() {
    val m1 = MM("L", 22)
    val m2 = MM("W", 23)
    val m3 = MM("L", 22)

    println(m1 === m2) // false
    println(m1 === m3) // false
    println(m2 !== m3) // true

    // `a == b`
    // is translated to:
    // `a?.equals(b) ?: (b === null)`

    println(m1 == m2) // false
    println(m1 == m3) // true
    println(m2 != m3) // true

}

data class MM(val name: String, val age: Int)
