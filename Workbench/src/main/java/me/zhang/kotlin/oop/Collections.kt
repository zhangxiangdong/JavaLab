package me.zhang.kotlin.oop

import kotlin.Number

/**
 * Created by zhangxiangdong on 2018/1/12.
 */
fun main(args: Array<String>) {
    testApis()
}

fun testApis() {
    // sort
    val numbers = listOf(3, 2, 1, 0, 4)
    val sortedNumbers = numbers.sorted()
    println(sortedNumbers)

    val users = listOf(
            UserBean("Lily", 23),
            UserBean("Kathy", 22),
            UserBean("Hanks", 24)
    )
    val sortedByName = users.sortedBy { it.name }
    val sortedByAge = users.sortedBy { it.age }
    println(sortedByName)
    println(sortedByAge)

    println("*******************")
    // zip
    val otherNumbers = listOf(7, 6, 9, 8, 5, 10) // the last element will be ignored
    val zippedNumbers = numbers.zip(otherNumbers)
    println(zippedNumbers)

    val userNames = listOf("Lily", "Kathy", "Hanks")
    val userAges = listOf(23, 22, 24)
    val userBeans = userNames.zip(userAges).map { UserBean(it.first, it.second) }
    println(userBeans)

    println("*******************")
    // fold
    val folded = numbers.fold(10, { acc, i -> acc + i }) // `10` + 3 + 2 + 1 + 0 + 4 = 10 + 10
    println(folded) // 20
    numbers.foldIndexed(10, { index, acc, i ->
        val acc1 = acc + i
        print("($index -> $acc1) ")
        acc1
    })
    println()

    println("*******************")
    // reduce
    val reduced = numbers.reduce { acc, i -> acc + i }
    println(reduced) // 10

    println("*******************")
    val readWriteMap = hashMapOf(
            'A' to 65,
            'a' to 97,
            'B' to 66,
            'b' to 98
    )
    println(readWriteMap['a'])

    val readOnlyMapSnapshot: Map<Char, Int> = HashMap(readWriteMap)
    println(readOnlyMapSnapshot)

    readWriteMap.put('b', -98)
    println(readOnlyMapSnapshot)
}

fun testMutableCollections() {
    val alphabets = mutableListOf("A", "B", "C")
    val readOnlyView: List<String> = alphabets
    println(readOnlyView) // [A, B, C]
    println(readOnlyView.last()) // C

    alphabets.add("D")
    println(readOnlyView) // [A, B, C, D]
    println(readOnlyView.first()) // A

    // readOnlyView.clear() // compile error

    val readWriteView: MutableList<String> = alphabets
    readWriteView.clear()
    alphabets.add("X")
    println(readWriteView) // [X]

    val stringSet = hashSetOf("a", "b", "b", "c", "d", "d")
    assert(stringSet.size == 4)

    val readOnlyList = listOf(1, 2, 3)
    val readOnlyNumbers: List<Number> = readOnlyList // the read-only types are covariant
    println(readOnlyNumbers)

    @Suppress("UNUSED_VARIABLE")
    val readWriteList = mutableListOf(1, 2, 3)
    // val readWriteNumbers: MutableList<Number> = readWriteList // compile error

    println("******************")
    val controller = Controller()
    for (i in 1..10) {
        controller.add(i)
    }
    val items = controller.items
    println(items)
    println(items.filter { it % 2 == 0 }) // [2, 4, 6, 8, 10]

    controller.remove(5)
    println(items)
    println(controller.size())

    println("******************")
    val list = listOf('1', "String", null, 1.0f, 23L)
    try {
        println(list.requireNoNulls())
    } catch (e: IllegalArgumentException) {
        println("null element found")
    }
    if (list.none { it == 0 }) println("no item == 0") // no item == 0
    println(list.firstOrNull { it is Number }) // 1.0
}

class Controller {

    private val _items = mutableListOf<Int>()
    // The toList extension method just duplicates the lists items,
    // thus, the returned list is guaranteed to never change.
    val items: List<Int> get() = _items.toList()

    fun add(str: Int) = _items.add(str)
    fun remove(str: Int) = _items.remove(str)
    fun size() = _items.size

}

data class UserBean(val name: String, val age: Int)