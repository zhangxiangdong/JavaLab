package me.zhang.kotlin.oop

import java.util.*
import javax.swing.Icon
import javax.swing.JButton
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by zhangxiangdong on 2018/1/2.
 */
fun main(args: Array<String>) {
    testFunctions()
}

fun testFunctions() {
    foo(baz = 4) // The default value bar = 3 is used
    foo(6, 7)

    bar { println("Hello, everybody!") }
    bar(1) { println("Hi, there!") }
    bar(1, 2) { println("Hello, everyone!") }

    println("************************")

    val str = "Complicated String"
    reformat(str)
    reformat(str,
            true,
            true,
            false,
            '_'
    )
    reformat(str,
            normalizeCase = true,
            upperCaseFirstLetter = true,
            divideByCamelHumps = false,
            wordSeparator = '_'
    )
    reformat(str, wordSeparator = '_')

    println("************************")

    // min(x = 1, 2) // all the positional arguments should be placed before the ```first``` named one
    println(min(1, y = 2))

    println("************************")

    val arrayOf = arrayOf("Apple", "Google", "Microsoft", "Amazone")
    testVararg(*arrayOf)
    testVararg("Baidu", "Alibaba", "Tencent", "Netease")
}

fun testVararg(vararg strings: String) {
    println(Arrays.toString(strings))
}

fun foo(bar: Int = 3, baz: Int) {
    println("bar: $bar, baz: $baz")
}

fun bar(foo: Int = 0, bar: Int = 1, func: () -> Unit) {
    println("foo: $foo, bar: $bar")
    func.invoke()
}

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
}

fun min(x: Int = 0, y: Int = 0) = if (x > y) y else x

fun testDelegation() {
    val p = PrinterImpl()
    DerivedPrinter0(p).print().also { println() }
    DerivedPrinter0(p).println()
    DerivedPrinter(p).print().also { println() }
    DerivedPrinter(p).println()

    println(Example().p)
    Example().p = "Example"

    println(Example().r)

    /* Standard Delegates */
    val lazyObject = LazyObject()
    println(lazyObject.lazyString) // executes the lambda passed to lazy() and remembers the result
    println(lazyObject.lazyString) // simply return the remembered result

    val book = Book()
    book.bookName = "A brief history of time"

    book.bookName = "Holy shit"
    book.isLegal = true // vetoed
    println("Is Legal: ${book.isLegal}") // false

    book.bookName = "Clean code"
    book.isLegal = true // allowed
    println("Is Legal: ${book.isLegal}") // true

    val infoMap = mapOf<String, Any?>( // immutable map
            "name" to "Kathy",
            "age" to 23,
            "gender" to 0 // 0: girl, 1: boy
    )
    val kathy = Student(infoMap)
    println(kathy)

    val mutableMap = mutableMapOf<String, Any?>(
            "name" to "Kane",
            "age" to 25,
            "gender" to 1
    )
    val kane = MutableStudent(mutableMap) // Student also works here -- change its fields via map
    println(kane)
    mutableMap.put("age", 27)
    println(kane)

}

fun testEnumClasses() {
    println(Integer.toHexString(Color.RED.getColorInt()))

    println(Integer.toHexString(Color.valueOf("GREEN").getColorInt()))

    val colors = Color.values()
    colors.forEach { println(it.name) }

    println(enumValues<Color>().joinToString { it.name })

    println(enumValueOf<Color>(Color.BLUE.name).name)
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

open class Super {

    open fun foo(i: Int = 10) {}

}

class Sub : Super() {

    // When overriding a method with default parameters values,
    // the default parameter values must be omitted from the signature
    override fun foo(i: Int) { // no default value allowed

    }

}

class MutableStudent(infoMap: MutableMap<String, Any?>) {

    var name: String by infoMap
    var age: Int by infoMap
    var gender: Int by infoMap

    override fun toString(): String {
        return "A Student($name, $age years old, ${if (gender == 0) "girl" else "boy"})"
    }
}

class Student(infoMap: Map<String, Any?>) {

    val name: String by infoMap
    val age: Int by infoMap
    val gender: Int by infoMap

    override fun toString(): String {
        return "A Student($name, $age years old, ${if (gender == 0) "girl" else "boy"})"
    }

}

class Book {

    var bookName: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("${property.name}: $oldValue -> $newValue")
    }

    var isLegal: Boolean by Delegates.vetoable(false) { _, _, _ ->
        !bookName.contains("shit") // book name without 'shit' will be set as legal
    }

}

class LazyObject {

    // By default, the evaluation of lazy properties is synchronized
    val lazyString: String by lazy {
        println("Working on it...")
        "Lazy String"
    }

    val lazyString0: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        ""
    }

}

class Example {
    // The expression after 'by' is the delegate
    var p: String by DelegateForMutableProperty()
    val q: String by DelegateForImmutableProperty()
    val r: String by Stub()
}

operator fun Stub.getValue(thisRef: Any?, property: KProperty<*>): String {
    return "$thisRef, thank you for delegating '${property.name}' to me!"
}

class Stub

class DelegateForMutableProperty {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class DelegateForImmutableProperty {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
}

interface Printer {
    fun print()
    fun println()
}

class PrinterImpl : Printer {
    override fun println() {
        println("PrinterImpl")
    }

    override fun print() {
        print("PrinterImpl")
    }
}

class DerivedPrinter0(p: Printer) : Printer by p {
    // The compiler will use your override implementations instead of those in the delegate object.
    override fun println() {
        println("DerivedPrinter0")
    }
}

class DerivedPrinter(p: Printer) : Printer by p {
    // The compiler will use your override implementations instead of those in the delegate object.
    override fun print() {
        print("DerivedPrinter")
    }
}

enum class ProtocolState {

    // Anonymous Classes
    WAITING {
        override fun signal() = TAKING

        // deprecated
        class Nested {}

        inner class Inner {}
    },

    TAKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState

}

enum class Color(private val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    fun getColorInt() = rgb
}

enum class Direction {
    // each enum constant is an object
    EAST,
    WEST,
    SOUTH,
    NORTH
}

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