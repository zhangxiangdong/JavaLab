package me.zhang.coreJava.db

import me.zhang.coreJava.utils.use
import java.sql.DriverManager

/**
 * Created by zhangxiangdong on 2018/2/6.
 */
fun main(args: Array<String>) {
    try {
        Class.forName("com.mysql.jdbc.Driver") // force loading of drive class

        var user: String? = null
        var password: String? = null
        if (args.size == 2) {
            user = args[0]
            password = args[1]
        }

        val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workbench", user, password)
        conn.use {
            val stmt = conn.createStatement()
            val rs = stmt.executeQuery("select * from books")
            while (rs.next()) {

                println("Title: ${rs.getString(1)}")
                println("ISBN: ${rs.getString(2)}")
                println("Publisher Id: ${rs.getString(3)}")
                println("Price: ${rs.getString(4)}")

                if (!rs.isLast) {
                    println("****************")
                }

            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}