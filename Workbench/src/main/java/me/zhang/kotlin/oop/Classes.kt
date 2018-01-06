package me.zhang.kotlin.oop

import javax.swing.Icon
import javax.swing.JButton

/**
 * Created by zhangxiangdong on 2018/1/2.
 */
fun main(args: Array<String>) {
    testNestedAndInnerClasses()
}

fun testNestedAndInnerClasses() {
    println(Outer.Nested().foo()) // 5
    println(Outer().Inner().foo()) // 4

    // anonymous inner classes
    val count = 3
    val fool = object : Foo {
        override val count: Int
            get() = count

        override fun f() {
            println(this.count) // 3
        }
    }
    fool(fool)
}

private fun testSealed() {
    val c = Const(3.0)
    println(eval(c))

    val s = Sum(Const(1.0), Const(2.0))
    println(eval(s))

    val n = NotANumber
    println(eval(n))
}

private fun testFields() {
    val fields = Fields()
    fields.counter = 2
    println(fields.counter)

    fields.table.put("A", 65)
    fields.table.put("a", 97)
    println(fields.table)
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

fun eval(e: Expression): Double = when (e) {
    is Const -> e.number
    is Sum -> eval(e.e1) + eval(e.e2)
    is NotANumber -> Double.NaN
}

fun fool(expr: Foo) {
    expr.f()
}

// ************************* CLASSES ****************************

sealed class Expression
data class Const(val number: Double) : Expression()
data class Sum(val e1: Expression, val e2: Expression) : Expression()
object NotANumber : Expression() {
    override fun toString(): String {
        return "not a number"
    }
}

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // public by default

    // marked as inner to be able to access members of outer class
    inner class Inner {
        public val e: Int = 5

        fun foo() = d
    }

    class Nested {
        public val e: Int = 5

        fun foo() = e
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
}

class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
    fun calc() {
        // Outer.Nested()
    }
}

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

object Consts {
    const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
}

class Fields {

    @Deprecated(SUBSYSTEM_DEPRECATED)
    fun foo() {
        println("Deprecated")
    }

    private var _table: HashMap<String, Int>? = null
    public val table: HashMap<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

    var size = 0

    val isEmpty: Boolean
        get() = this.size == 0 //  there will be no backing field

    val hasData = this.size != 0 // has type Boolean

    var stringRepresentation: String
        get() = toString()
        set(aString) = setDataFromString(aString)

    var setterVisibility: String = "default"
        private set // the setter is private and has the default implementation

    var counter = 0 // the initializer value is written directly to the backing field
        set(value) {
            if (value > 0) {
                field = value
            } else {
                throw IllegalArgumentException("value must > 0, value: $value")
            }
        }

    var selectedColor: Int = -1
        get() {
            if (field > 0)
                return field
            return 0
        }
        set(color) {
            if (color > 0)
                field = color
        }

    private fun setDataFromString(aString: String) {

    }

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

    val string: String
        get() {
            return "default string"
        }

    fun f()

    fun bar() {
        println(string)
    }
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