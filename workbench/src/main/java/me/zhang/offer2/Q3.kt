package me.zhang.offer2

import org.jetbrains.annotations.NotNull

/**
 * 二维数组中的查找
 *
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 1  2  8   9
 * 2  4  9  12
 * 4  7 10  13
 * 6  8 11  15
 */
object Q3 {
    @JvmStatic
    fun main(args: Array<String>) {
        val row0: IntArray = intArrayOf(1, 2, 8, 9)
        val row1: IntArray = intArrayOf(2, 4, 9, 12)
        val row2: IntArray = intArrayOf(4, 7, 10, 13)
        val row3: IntArray = intArrayOf(6, 8, 11, 15)
        val twoD: Array<IntArray> = arrayOf(row0, row1, row2, row3)

        val hasThisValue = Q3(twoD).hasThisValue0(8)
        println(hasThisValue)
    }

    internal class Q3(@field:NotNull private val twoD: Array<IntArray>) {
        fun hasThisValue0(targetValue: Int): Boolean {
            var hasThisValue = false
            twoD.forEachIndexed outer@{ row, arr ->
                arr.forEachIndexed inner@{ col, value ->
                    if (value == targetValue) {
                        hasThisValue = true
                        println("row: $row, col: $col")
                    }
                }
            }
            return hasThisValue
        }
    }

}