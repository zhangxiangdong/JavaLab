package me.zhang.kotlin.oop

import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import javax.swing.Icon
import javax.swing.JButton
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.TreeNode
import kotlin.coroutines.experimental.SequenceBuilder
import kotlin.coroutines.experimental.buildIterator
import kotlin.coroutines.experimental.buildSequence
import kotlin.math.cos
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by zhangxiangdong on 2018/1/2.
 */
fun main(args: Array<String>) {
    testCoroutines()
}

fun testCoroutines() {
    async {
        Thread.sleep(3000)
    }

    fibonacciSeq()
    lazySeq0()
    lazySeq1()
    lazyIterator()

    extensions()
}

fun extensions() {
    val lazySeq = buildSequence {
        yieldIfOdd(20..30)
    }

    lazySeq.forEach { print("$it ") }
}

suspend fun SequenceBuilder<Int>.yieldIfOdd(elements: Iterable<Int>) {
    val iterator = elements.iterator()
    while (iterator.hasNext()) {
        val x = iterator.next()
        if (x % 2 != 0) yield(x)
    }
}

fun lazyIterator() {
    val lazyIterator = buildIterator {
        yieldAll(10..19)
    }

    lazyIterator.forEach { print("$it ") }
    println()
}

fun lazySeq1() {
    val lazySeq = buildSequence {
        yield(0)
        yieldAll(1..9)
    }

    lazySeq.forEach { print("$it ") }
    println()
}

fun lazySeq0() {
    // sampleStart
    val lazySeq = buildSequence {
        print("START ")
        for (i in 1..5) {
            yield(i)
            print("STEP ")
        }
        print("END")
    }

    // Print the first three elements of the sequence
    lazySeq.take(3).forEach { print("$it ") }
    println()
    // sampleEnd
}

fun fibonacciSeq() {
    // sampleStart
    val fibonacciSeq = buildSequence {
        var a = 0
        var b = 1

        yield(1)

        while (true) {
            yield(a + b)

            val tmp = a + b
            a = b
            b = tmp
        }
    } // sampleEnd

    println(fibonacciSeq.take(8).toList())
}

fun <T> async(block: suspend () -> T) {

}

fun testInline() {
    val arrayListOfLetters = arrayListOf("Moon", "nIGHT", "Nope", "Xforce")
    val nString = lowercaseStringStartsWithN(arrayListOfLetters)
    println(nString)

    println("********************")
    println(hasZeros(arrayListOf(1, 2, 3, 0, 2, 5)))

    println("********************")
    DefaultMutableTreeNode().findParentOfType<DefaultMutableTreeNode>()
}

inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

fun lowercaseStringStartsWithN(strs: List<String>): String? {
    var str: String? = null
    run stop@ {
        strs.forEach {
            if (it.startsWith("N", true)) {
                str = it
                return@stop
            }
        }
    }
    return str?.toLowerCase()
}

fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true // returns from hasZeros
    }
    return false
}

fun testLambdas() {
    val input = arrayListOf("M", "n", "O", "p", "Q")
    println(input.map { it -> it.toLowerCase() })
    println(input.map({ it.toUpperCase() }))
    println(input.map { it })

    println("******************")
    val keywords = arrayListOf("String", "Int", "Boolean", "Double")
    val max = keywords.unique { l, r -> l < r }
    println(max)
    val min = keywords.unique { l, r -> l > r }
    println(min)

    println("******************")
    val sumFunc: ((x: Int, y: Int) -> Int)? = { x, y -> x + y }
    println(sum(1, 2, sumFunc))
    println(sum(1, 2, null))
    println(sum(1, 2, { x, y -> x + y }))

    println("******************")
    val ints = arrayListOf(-3, -2, -1, 0, 1, 2, 3)
    println(ints.filter {
        val shouldFilter = it > 0 && it % 2 != 0
        shouldFilter // return@filter shouldFilter
        // return // return from the enclosing function -- ``` testLambdas() ```
    })

    val filtered = ints.filter(fun(i): Boolean {
        return i > 0 // return inside an anonymous function will return from the anonymous function itself
    })
    println(filtered)

    println("******************")
    var summary = 0
    filtered.forEach {
        summary += it // access its closure
    }
    println(summary)

    val jia: Int.(other: Int) -> Int = { this + it } // Function Literals with Receiver
    println(3.jia(7)) // 10
    val jian = fun Int.(other: Int) = this - other // a function type with receiver
    println(7.jian(3)) // 4

    val represents: String.(other: Int) -> Boolean = { toIntOrNull() == it }
    println("211".represents(211)) // true
    println("985".represents(911)) // false

    fun testOperation(op: (String, Int) -> Boolean, str: String, int: Int, expected: Boolean) {
        assert(op.invoke(str, int) == expected)
    }
    testOperation(represents, "123", 123, true) // test OK

    println("******************")
    /* Anonymous Functions */
    val sum0 = fun(x: Int, y: Int): Int {
        return x + y
    }
    val sum1 = fun(x: Int, y: Int): Int = x + y
    println(sum(1, 2, sum0))
    println(sum(1, 2, sum1))

    println("******************")
    fun html(initProcedure: Html.() -> Unit): Html { // get an Html instance (already initialized)
        val html = Html()
        html.initProcedure()
        return html
    }

    println(Html().body()) // print ```null```
    val html = html {
        init() // calling a method on the receiver object
    }
    println(html.body()) // print out body
}

private fun sum(x: Int, y: Int, sum: ((x: Int, y: Int) -> Int)?): Int {
    return sum?.invoke(x, y) ?: 0
}

fun <T> Collection<T>.unique(calc: (T, T) -> Boolean): T? {
    var target: T? = null
    for (item in this) {
        if (target == null || calc(target, item)) {
            target = item
        }
    }
    return target
}

private fun timeConsumingFunc() {
    fun toBeSynchronized() = complicatedCalc()
    println(compute(ReentrantLock(), ::toBeSynchronized)) // function references

    println(compute(ReentrantLock(), { complicatedCalc() })) // lambda expression
    println(compute(ReentrantLock()) {
        complicatedCalc()
    })
}

fun <I, O> List<I>.map(transform: (I) -> O): List<O> {
    val result = arrayListOf<O>()
    @Suppress("LoopToCallChain")
    for (item in this) {
        result.add(transform(item))
    }
    return result
}

inline fun <T> compute(lock: Lock, expr: () -> T): T {
    lock.lock()
    try {
        return expr.invoke()
    } finally {
        lock.unlock()
    }
}

fun complicatedCalc(): String {
    Thread.sleep(1000)
    return "Complicated Results!"
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

    println("************************")

    val arrayOfAnys = arrayOf("m", 1, 'c')
    // if we already have an array and want to pass its contents to the function,
    // we use the spread operator (prefix the array with *)
    val list = asList("N", 3, "Q", 'h', *arrayOfAnys, null, 1.2f)
    list.forEach { print("$it ") }

    println("************************")
    val s0 = "Hello"
    val s1 = " "
    val s2 = "World"
    val s3 = "!"
    // call extension function using infix notation
    println(s0 plus s1 plus s2 plus s3)

    println("************************")
    println(findFixPoint()) // 0.7390851332151607
    println(findFixPoint0())
}

tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == cos(x)) x else findFixPoint(cos(x))

private fun findFixPoint0(): Double {
    var x = 1.0
    while (true) {
        val y = cos(x)
        if (x == y) return x
        x = y
    }
}

infix fun String.plus(s: String): String {
    return "$this$s" // concatenation
}

fun <T> asList(vararg ts: T) = ts.toList()

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

class Html {

    private var body: String? = null

    fun init() {
        println("Html initialized!")
        body = "This is html body."
    }

    fun body() = body

}

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

    inline val isEmpty: Boolean
        get() = this.size == 0 //  there will be no backing field

    val hasData = this.size != 0 // has type Boolean

    var stringRepresentation: String
        inline get() = toString()
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