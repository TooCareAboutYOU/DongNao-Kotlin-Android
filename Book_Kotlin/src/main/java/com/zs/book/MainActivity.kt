package com.zs.book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity(), Comparable<String> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 10 downTo 1 step 2) {
            println("打印 $i")
        }
//        User.newSubscribingUser("sefsd@qq.com")

        //lambda表达式存储到一个变量中，把变量当做普通函数对待
        val sum = { x: Int, y: Int -> toast("求和： ${x + y}") }
        val sum1 = { x: Int, y: Int -> x + y }
        println("输出和：${sum1(3, 7)}")

        val btn = findViewById<AppCompatButton>(R.id.acBtnTouch)
        btn.setOnClickListener {
            sum(1, 2)
        }

    }

    fun testNull(s: String?): String {
        return s ?: throw NullPointerException("为空了")
    }

    override fun compareTo(other: String): Int {


        return Objects.requireNonNull(other).length
    }


}
