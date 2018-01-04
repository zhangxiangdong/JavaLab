package me.zhang.kotlin.oop

/**
 * Created by zhangxiangdong on 2018/1/4.
 */
fun main(args: Array<String>) {
    println(User())

    // Data class
    val ricky = User("Ricky", 25)
    println(ricky)

    // Copying
    val olderRicky = ricky.copy(age = 30)
    println(olderRicky)

    // Destructuring
    val (n, a) = ricky
    println("name: $n, age: $a")

    // Standard data classes
    val lucy = Pair("Lucy", 23)
    println(lucy)
    val (name, age, gender) = Triple("Wendy", 24, 0)
    println("name: $name, age: $age, gender: ${if (gender == 0) "F" else "M"}")
}

data class User(val name: String = "", val age: Int = 0)