package com.dongnao.kotlin.h

import android.view.View
import android.widget.Button

/**
 * 动脑视频第三节 第一段视频: lsn3_0_Kotlin高级特性1_lambda、操作符重载与协程.vep
 */

//lambda表达式
val action: (i: Int, j: Int) -> Unit = { i: Int, j: Int ->
    val result = i + j
    println("打印：$result")
}

//函数表达式
fun calculate(i: Int, j: Int) {
    val result = i + j
    println("打印：$result")
}

fun main(args: Array<String>) {

    action(1, 2)

    calculate(1, 2)

    val list = arrayListOf(1, 2, 3)
    list.forEach { values -> println("$values") }

    val button: Button? = null
    val onclick = { view: View ->

    }
    button?.setOnClickListener(onclick)


}


