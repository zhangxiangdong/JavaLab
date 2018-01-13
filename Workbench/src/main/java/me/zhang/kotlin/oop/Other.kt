package me.zhang.kotlin.oop

/**
 * Created by zhangxiangdong on 2018/1/13.
 */
fun main(args: Array<String>) {
    testEquality()
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
