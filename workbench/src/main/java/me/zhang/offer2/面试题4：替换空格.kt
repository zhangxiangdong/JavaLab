package me.zhang.offer2

import kotlin.math.max

/**
 * 替换空格
 *
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入“We are happy.”，则输出“We%20are%20happy.”。
 */
object Q4 {

    @JvmStatic
    fun main(args: Array<String>) {
        val source = "We are happy."
        val result = source.replace(" ", "%20")
        println(result)
    }

}

/**
 * 有两个排序的数组A1和A2，内存在A1 的末尾有足够多的空余空间容纳A2。
 * 请实现一个函数，把A2中的所有数字插入到A1 中并且所有的数字是排序的。
 */
object Q4ex1 {

    @JvmStatic
    fun main(args: Array<String>) {
        val a1 = intArrayOf(1, 3, 5, 7, 9)
        val a2 = intArrayOf(0, 2, 4, 6, 8)
        val size1 = a1.size
        val size2 = a2.size
        val a3 = IntArray(size1 + size2)

        var i1 = size1 - 1;
        var i2 = size2 - 1;
        var i3 = a3.size - 1

        // 从尾部开始，依次向头部比较两个数组中的数，较大的那个优先插入新建容器的尾部，直到遍历完所有数据
        for (i in (0 until size1).reversed()) {
            if (a1[i1] > a2[i2]) {
                a3[i3--] = a1[i1--]
                a3[i3--] = a2[i2--]
            } else {
                a3[i3--] = a2[i2--]
                a3[i3--] = a1[i1--]
            }
        }
        println(a3.contentToString())
    }

}