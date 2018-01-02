package me.zhang.kotlin.oop

import javax.swing.Icon
import javax.swing.JButton

/**
 * Created by zhangxiangdong on 2018/1/2.
 */
fun main(args: Array<String>) {
    testSuperKeyword()
}

private fun testSuperKeyword() {
    Bar2(3).Baz().g()
    C().f()
}

private fun testConstructors() {
    val lucia = Customer("Lucia")
    println(lucia.name)
    val ricky = Customer("Ricky", "Beijing")
    println("${ricky.name} + ${ricky.address}")

    Constructors(1)

    // DontCreateMe()
    val dontCreateMe = DontCreateMe.getInstance()

    MyButton("My Button")
}

open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } // interface members are 'open' by default

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    // The compiler requires f() to be overridden:
    override fun f() {
        super<A>.f() // call to A.f()
        super<B>.f() // call to B.f()
    }
}

interface Foo {
    val count: Int
    fun f()
}

open class Bar1 : Foo {

    override val count: Int
        get() = 0

    override fun f() {
        println("Bar1.f()")
    }

}

class Bar2(override var count: Int) : Bar1() {

    override fun f() {
        println("Bar2.f()")
    }

    inner class Baz {

        fun g() {
            super@Bar2.f() // Calls Bar1's implementation of f()
            f()
            println("Baz.g()")
            println(super@Bar2.count) // Uses Bar1's implementation of count's getter
            println(count)
        }

    }
}

open class MyButton : JButton {

    constructor(text: String) : super(text)

    constructor(icon: Icon) : super(icon)

}

open class Base(p: Int) {

    open val x: Int = p
    open var y: Int = p

    open fun foo() {} // overridable
    fun bar() {} // final method, can't be override
    final fun ext() {}
    open fun nv() {}
}

abstract class MoreDerived(p: Int) : Base(p) {

    override abstract fun foo()

}

open class AnotherDerived(p: Int) : Base(p) { // "overridable" class

    override val x: Int get() = super.x
    // override val y: Int = super.y // illegal: can't override var property with a val property

    final override fun nv() { // prohibit re-overriding
        super.nv()
    }

}

class Derived(p: Int) : Base(p) { // "final" class

    override val x: Int
        get() = super.x

    override fun foo() { // must add "override" explicitly
        super.foo()
    }

    // override fun bar() {} // illegal

    // override fun ext() {} // illegal

}

class DontCreateMe private constructor() {

    companion object {
        fun getInstance(): DontCreateMe {
            return DontCreateMe()
        }
    }

}

class Constructors {

    /* the code in all initializer blocks is executed before the secondary constructor body */
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

class Customer public constructor(val name: String) {

    var address = ""

    constructor(name: String, address: String) : this(name) {
        this.address = address
    }

}

class InitOrder(name: String) {

    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: $name".also(::println)

    init {
        println("Second initializer block that prints $name")
    }

    val thirdProperty = name.toUpperCase().also(::println)

}

class Person(val firstName: String, val lastName: String, var age: Int) {

}

class Empty // Implicitly inherits from Any