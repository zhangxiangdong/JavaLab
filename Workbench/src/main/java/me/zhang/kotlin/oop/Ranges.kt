package me.zhang.kotlin.oop

/**
 * Created by zhangxiangdong on 2018/1/12.
 */
fun main(args: Array<String>) {
    testRanges()
}

fun testRanges() {
    for (i in 1..3) { // 1 2 3
        print("$i ")
    }
    println()

    for (i in 3..1) {
        print("$i ")
    }

    for (i in 3 downTo 1) { // 3 2 1
        print("$i ")
    }
    println()

    for (i in 1..9 step 3) { // 1 4 7
        print("$i ")
    }
    println()

    // [1, 3)
    for (i in 1 until 3) { // 1 2
        print("$i ")
    }
    println()

    IntRange(5, 7).forEach { print("$it ") }.also { println() } // 5 6 7
    IntProgression
            .fromClosedRange(7, 12, 2)
            .forEach { print("$it ") }
            .also { println() } // 7 9 11

    1.rangeTo(5).forEach { print("$it ") }.also { println() } // 1 2 3 4 5

    5.downTo(1).step(2).forEach { print("$it ") }.also { println() } // 5 3 1

    3.rangeTo(8).reversed().forEach { print("$it ") }.also { println() } // 8 7 6 5 4 3

}
