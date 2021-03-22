package com.dongnao.kotlin.h

/**
 * @author zhangshuai
 * @date 2021/3/22 15:46
 * @email zhangshuai@dushu.io
 * @description 动脑视频第一节 第二段视频: lsn1_1_Kotlin基础语法_函数、变量、类、枚举与控制流.vep
 */

fun max(x: Int, y: Int) = if (x > y) {
    x
} else {
    y
}

fun max2(x: Int, y: Int) = when {
    x > y -> x
    else -> y
}

//顶层变量
const val i: String = "1" //final
var j = "2"

//顶层函数
fun main(args: Array<String>) {

    val z: String = "z"
    printlns(z)
    val str = "i: ${i}, j: ${j}, z: ${z}"
    printlns(str)
    j = "3"
    printlns(str)

    when (Color.RED) {
        Color.RED -> printlns("red")
        Color.GREEN -> printlns("green")
        Color.YELLOW -> printlns("yellow")
    }

    when {
        1 + 1 == 3 -> printlns("when 函数1")
        text() -> printlns("when 函数2")
    }

    //依次循环1-10直接
    val range: IntRange = 0..10
    //自定义标签loop,跳出进入到标签中
    loop@ for (i in range) {
        if (i == 2) {
            continue@loop
        }
    }

//    val person = Person("Hello")
//    person.name = "World"
//    person.isMarrid = false
}

fun text(): Boolean = true

fun printlns(s: Any?) {
    println("打印：${s}")
}

//class Person(var name: String) {
//    var isMarrid: Boolean = false
//        get() = true
//        set(value) {
//            field = value
//        }
//
//}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    YELLOW(1, 2, 3),
    GREEN(4, 5, 6);

    fun rgb(): Int = r + g + b
}