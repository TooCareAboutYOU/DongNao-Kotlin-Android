package com.dongnao.kotlin.h

import android.view.View
import android.widget.Button

fun main(args: Array<String>) {

    //lambda表达式
    val action = { i: Int, j: Int ->
        val result = i + j
        println("打印：$result")
    }
    action(1, 2)

    calculate(1, 2)

    val list = arrayListOf(1, 2, 3)
    list.forEach { values -> println("$values") }

    val button: Button? = null
    val onclick={view:View->

    }
    button?.setOnClickListener(onclick)


}

//函数表达式
fun calculate(i: Int, j: Int) {
    val result = i + j
    println("打印：$result")
}
