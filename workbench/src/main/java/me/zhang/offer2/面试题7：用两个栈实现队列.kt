package me.zhang.offer2

import java.util.*

/**
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

 * 测试用例：
 * ● 往空的队列里添加、删除元素。
 * ● 往非空的队列里添加、删除元素。
 * ● 连续删除元素直至队列为空。
 */
object Q7 {

    @JvmStatic
    fun main(args: Array<String>) {
        val customQueue = CustomQueue()
        for (i in 0..9) {
            customQueue.appendTail(i)
        }

        while (!customQueue.empty()) {
            println(customQueue.deleteHead())
        }
    }

    internal class CustomQueue {

        private val stackA = Stack<Int>()
        private val stackB = Stack<Int>()

        fun empty(): Boolean {
            return stackA.empty() && stackB.empty()
        }

        fun appendTail(value: Int) {
            stackA.push(value)
        }

        fun deleteHead(): Int? {
            var head: Int? = null

            if (!stackB.empty()) {
                head = stackB.pop()
            } else {
                while (!stackA.empty()) {
                    stackB.push(stackA.pop())
                }
                if (!stackB.empty()) {
                    head = stackB.pop()
                }
            }

            return head
        }

    }

}