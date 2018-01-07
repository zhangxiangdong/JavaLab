package me.zhang.kotlin.oop

/**
 * Created by Zhang on 1/7/2018 1:34 PM.
 */
fun main(args: Array<String>) {
    testObjectExpressions()
}

private fun testObjectExpressions() {
    complicatedOE()
    simpleOE()
}

fun simpleOE() {
    val point = object {
        val x: Int = 2
        val y: Int = 4
    }
    println("Point(${point.x}, ${point.y})")

    Object().printPoint()

    val dontNewMe = DontNewMe.create()
    println(dontNewMe.string())
}

private fun complicatedOE() {
    var clickCount = 0
    var enterCount = 0
    val window = Window()
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: Event) {
            super.mouseClicked(e)
            clickCount++ // code in object expressions can access variables from the enclosing scope
            // Unlike Java, this is not restricted to final variables.
            println("${e.name}: $clickCount")
        }

        override fun mouseEntered(e: Event) {
            super.mouseEntered(e)
            enterCount++
            println("${e.name}: $enterCount")
        }
    })
    window.onMouseClicked()
    window.onMouseEntered()
}

interface Factory<out T> {
    fun create(): T
}

class DontNewMe private constructor() {

    companion object : Factory<DontNewMe> {
        override fun create() = DontNewMe()
    }

    fun string() = "DontNewMe"

}

class Object {

    // Private function, so the return type is the anonymous object type
    private val point = object {
        val x = 3
        val y = 2

        override fun toString() = "Point($x, $y)"
    }

    // Public function, so the return type is Any
    public fun getPoint() = object {
        val x = 1
        val y = 5

        override fun toString() = "Point($x, $y)"
    }

    fun printPoint() {
        println(point)
        println(getPoint())

        println(point.x)
        // println(getPoint().x) // ERROR: Unresolved reference 'x'
    }

}

class Window {

    private var listener: ActionListener? = null

    fun addMouseListener(listener: ActionListener) {
        this.listener = listener
    }

    fun onMouseClicked() {
        listener?.mouseClicked(Event("Clicked"))
    }

    fun onMouseEntered() {
        listener?.mouseEntered(Event("Entered"))
    }

}

open class MouseAdapter : ActionListener {

    override fun mouseClicked(e: Event) {
    }

    override fun mouseEntered(e: Event) {
    }

}

interface ActionListener {

    fun mouseClicked(e: Event)

    fun mouseEntered(e: Event)

}

class Event(val name: String)