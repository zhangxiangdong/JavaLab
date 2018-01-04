package me.zhang.kotlin.oop

/**
 * Created by zhangxiangdong on 2018/1/3.
 */
fun main(args: Array<String>) {
    testExtensionFunctions()
}

private fun testExtensionFunctions() {
    val m = mutableListOf(1, 2, 3)
    println(m)
    m.swap(0, 2)
    println(m)

    val n = mutableListOf("A", "B", "C")
    println(n)
    n.swap(0, 2)
    println(n)

    printFoo(M())
    printFoo(N()) // extension functions are dispatched statically
    println(N().foo()) // the member always wins
    println(N().foo(1)) //  overload member functions

    arrayOf("O", null, "Q", "R").forEach { print("${it.toString()} ") }.also { println() }

    val alphabets = listOf("X", "Y", "Z", "A", "B", "C")
    println("Last index of alphabets: ${alphabets.lastIndex}")
}

class D {
    fun bar() {}
}

class E {

    fun call(d: D) {
        d.foo()
    }

    fun baz() {
        // bar()
    }

    private fun D.foo() {
        bar()
        baz()
    }

    fun D.string() {
        toString() // calls D.toString()
        this@E.toString() // calls E.toString()
    }

}

val <T> List<T>.lastIndex: Int // initializers are not allowed for extension properties
    get() = this.size - 1

fun Any?.toString() = this?.toString() ?: "null"

open class M
class N : M() {
    fun foo() = "N"
}

fun M.foo() = "m"
fun N.foo() = "n"
fun N.foo(i: Int) = "n$i"

// the extension function being called is determined by the type of the expression on which the function is invoked,
// not by the type of the result of evaluating that expression at runtime
fun printFoo(m: M) {
    println(m.foo())
}

fun <T> MutableList<T>.swap(l: Int, r: Int) {
    val temp = this[l]
    this[l] = this[r]
    this[r] = temp
}