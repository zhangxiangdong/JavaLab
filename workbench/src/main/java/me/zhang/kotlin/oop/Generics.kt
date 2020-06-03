package me.zhang.kotlin.oop

import me.zhang.kotlin.oop.Util.compare
import me.zhang.kotlin.oop.Util.copy
import me.zhang.kotlin.oop.Util.copyWhenGreater
import me.zhang.kotlin.oop.Util.fill
import me.zhang.kotlin.oop.Util.foo
import me.zhang.kotlin.oop.Util.getNextItem
import me.zhang.kotlin.oop.Util.sort
import java.util.*

/**
 * Created by zhangxiangdong on 2018/1/4.
 */
fun main(args: Array<String>) {
    testGenericContraints()
}

fun testGenericContraints() {
    val alphabets = arrayListOf("M", "P", "Z", "A")
    sort(alphabets)
    println(alphabets)

    val threshold = "B"
    println(copyWhenGreater(alphabets, threshold))
}

fun testGenericFunctions() {
    println(Util.singletonList(3))
}

fun testStarProjections() {
    foo(2, object : Function<Int, List<String>> {
        override fun eval(t: Int): List<String> {
            val i2s = t.toString()
            return arrayListOf(i2s, i2s, i2s)
        }
    })
}

private fun testTypeProjections() {
    val from = arrayOf(1, 2, 3)
    val to = Array<Any>(3, { 0 })
    copy(from, to)
    println(Arrays.toString(to))

    val dest = Array(5, { "" })
    fill("X", dest)
    println(Arrays.toString(dest))

    val arrayOfAnys = Array<Any>(5, { 0 })
    fill("Y", arrayOfAnys)
    println(Arrays.toString(arrayOfAnys))

    val arrayOfInts = Array(5, { 0 })
    fill(3, arrayOfInts)
    println(Arrays.toString(arrayOfInts))
}

private fun testGenerics() {
    val box = Box(3)
    println(box.produce())
    box.consume(4)
    println(box.produce())

    val strings = Strings(listOf("A", "B", "C"))
    println(getNextItem(strings))
    println(getNextItem(strings))
    println(getNextItem(strings))
    println(getNextItem(strings))

    println(compare(2, 1, Comp()) > 0)
}

interface Function<in T, out U> {
    fun eval(t: T): U
}

class Comp : Comparator0<Number> {
    override fun compare0(l: Number, r: Number) = l.toInt() - r.toInt()
}

interface Comparator0<in T> {
    fun compare0(l: T, r: T): Int
}

object Util {

    /**
     * Only one upper bound can be specified inside the angle brackets.
     * If the same type parameter needs more than one upper bound, we need a separate where-clause:
     */
    fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
            where T : CharSequence,
                  T : Comparable<T> {
        return list.filter { it > threshold }.map { threshold.toString() }
    }

    // Upper bounds
    fun <T : Comparable<T>> sort(list: List<T>) {
        Collections.sort(list)
    }

    fun <T> singletonList(value: T): List<String> {
        return Collections.singletonList(value.basicToString())
    }

    private fun <T> T.basicToString(): String {
        return "*** ${this.toString()} ***"
    }

    fun compare(a: Int, b: Int, c: Comparator0<Number>): Int {
        c.compare0(a, b) // Int is subtype of Number
        val cc: Comparator0<Int> = c
        return cc.compare0(a, b)
    }

    fun getNextItem(strings: Source<String>): Any? {
        val objects: Source<Any> = strings
        return objects.next()
    }

    // Consumer in, Producer out!
    // type projection
    fun copy(from: Array<out Any>, to: Array<in Any>) {
        assert(from.size <= to.size)

        for (i in from.indices) {
            to[i] = from[i]
            // from[i] = to[i] // prohibit it from writing to from
        }
    }

    fun fill(value: String, dest: Array<in String>) {
        println("<String> fill")
        for (i in dest.indices) {
            dest[i] = value
        }
    }

    fun <T> fill(value: T, dest: Array<in T>) {
        println("<T> fill")
        for (i in dest.indices) {
            dest[i] = value
        }
    }

    fun bar(expr: Function<*, String>) { // Function<in Nothing, String>

    }

    fun foo(input: Int, expr: Function<Int, *>) { // Function<Int, out Any?>
        println(expr.eval(input))
    }

    fun baz(expr: Function<*, *>) { // Function<in Nothing, out Any?>

    }

}

interface Source<out T> {
    fun next(): T?
}

class Strings(strings: List<String>) : Source<String> {

    private val iterator = strings.iterator()

    override fun next(): String? {
        if (iterator.hasNext()) {
            return iterator.next()
        }
        return null
    }

}

class Box<T>(t: T) {

    private var value = t

    fun produce(): T {
        return value
    }

    fun consume(t: T) {
        value = t
    }

}