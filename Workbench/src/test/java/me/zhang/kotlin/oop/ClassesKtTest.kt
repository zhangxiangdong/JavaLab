package me.zhang.kotlin.oop

import org.junit.Before
import org.junit.Test

/**
 * Created by zhangxiangdong on 2018/1/3.
 */
class ClassesKtTest {

    lateinit var obj: Fields

    @Before
    fun setUp() {
        obj = Fields()
    }

    @Test
    fun test() {
        obj.foo()
    }

}