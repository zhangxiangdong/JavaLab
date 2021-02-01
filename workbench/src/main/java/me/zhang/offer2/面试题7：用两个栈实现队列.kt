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
        //region Custom Queue
        val customQueue = CustomQueue()
        for (i in 0..9) {
            customQueue.appendTail(i)
        }
        while (!customQueue.empty()) {
            println(customQueue.deleteHead())
        }
        //endregion

        println()

        //region Custom Stack
        val customStack = CustomStack()
        for (i in 0..9) {
            customStack.push(i)
        }
        while (!customStack.empty()) {
            println(customStack.pop())
        }
        //endregion
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

    internal class CustomStack {

        private val queueA = LinkedList<Int>()
        private val queueB = LinkedList<Int>()

        fun empty(): Boolean {
            return queueA.isEmpty() && queueB.isEmpty()
        }

        fun push(value: Int) {
            queueA.add(value)
        }

        fun pop(): Int? {
            var top: Int? = null
            if (queueA.isEmpty()) {
                for (i in 0 until queueB.size - 1) {
                    queueA.add(queueB.poll())
                }
                top = queueB.poll() // 最后一个元素
            } else if (queueB.isEmpty()) {
                while (!queueA.isEmpty()) {
                    val result = queueA.poll()
                    if (queueA.isEmpty()) {
                        top = result // 最后一个元素
                        break
                    } else {
                        queueB.add(result)
                    }
                }
            }
            return top
        }

    }

}