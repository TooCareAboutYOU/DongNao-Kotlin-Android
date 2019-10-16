//设置文件类 别名
@file:JvmName("Hello")

package com.dongnao.kotlin.a

import java.lang.NullPointerException


var names = """
    {
        "date": "15",
        "high": "高温 18℃",
        "low": "低温 8℃",
        "ymd": "2019-10-15",
        "week": "星期二",
        "sunrise": "06:19",
        "sunset": "17:35",
        "aqi": 57,
        "fx": "西风",
        "fl": "<3级",
        "type": "晴",
        "notice": "愿你拥有比阳光明媚的心情"
    }
""".trimIndent()

//public static final
const val userSex = "男"

fun String.myTest() {

}

fun Int.myTest() {

}

//相同的签名
@JvmName("StringTest")
fun List<String>.myTest() {

}

fun List<Int>.myTest() {
    A("Q").names
}

class A(val name: String) {

    //在Java中具有与kotlin一样的可见性
    @JvmField
    val names = name

    //伴生类
    companion object Jvm {
        val id = "12"
    }
}

object B {
    val name: String = "1"
    fun bMethod() {
    }
}

//重载 自动生成多个构造函数
@JvmOverloads
fun params(name: String = "你好", sex: Int = 1) {

}

//强制try-catch 抛出异常
@Throws(NullPointerException::class)
fun myEx(){
    throw NullPointerException("哈哈，异常了吧")
}



