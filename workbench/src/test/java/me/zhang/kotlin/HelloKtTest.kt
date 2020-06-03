package me.zhang.kotlin

import org.junit.Test
import kotlin.test.assertFailsWith

/**
 * Created by Zhang on 12/24/2017 4:54 PM.
 */
class HelloKtTest {

    @Test
    fun sum() {
        val a = 1
        val b = 3
        assert(me.zhang.kotlin.sum(a, b) == 4)
    }

    @Test
    fun minus() {
        val a = 3
        val b = 2
        assert(me.zhang.kotlin.minus(a, b) == 1)
    }

    @Test
    fun incrementX() {
        me.zhang.kotlin.incrementX()
        assert(me.zhang.kotlin.x == 1)
    }

    @Test
    fun maxOf() {
        val a = 2
        val b = 4
        assert(maxOf(a, b) == 4)
    }

    @Test
    fun minOf() {
        val a = 2
        val b = 4
        assert(minOf(a, b) == 2)
    }

    @Test
    fun printProduct() {
        var m = "3"
        var n = "4"
        assert(calcProduct(m, n) == 12)

        m = "a"
        assert(calcProduct(m, n) == null)

        n = "b"
        assert(calcProduct(m, n) == null)
    }

    @Test
    fun getStringLength() {
        val s = "A string"
        assert(getStringLength(s) == 8)

        val o = 1
        assert(getStringLength(o) == null)
    }

    @Test
    fun describe() {
        val one = 1
        val greeting = "Hello"
        val long = Long.MAX_VALUE
        val notAString = 1.0f
        val unknown = "unknown"
        assert(me.zhang.kotlin.describe(one) == "One")
        assert(me.zhang.kotlin.describe(greeting) == "Greeting")
        assert(me.zhang.kotlin.describe(long) == "Long")
        assert(me.zhang.kotlin.describe(notAString) == "Not a string")
        assert(me.zhang.kotlin.describe(unknown) == "Unknown")
    }

    @Test
    fun transform() {
        var color = "red"
        assert(transform(color) == 0)

        color = "Blue"
        assert(transform(color) == 2)

        color = "gReeN"
        assert(transform(color) == 1)

        color = "ORANGE"
        assertFailsWith(IllegalArgumentException::class) { transform(color) }
    }

    @Test
    fun divide() {
        assert(divide(4, 2) == 2)

        assertFailsWith(ArithmeticException::class) {
            divide(1, 0)
        }
    }

}