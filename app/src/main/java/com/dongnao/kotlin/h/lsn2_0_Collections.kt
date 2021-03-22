package com.dongnao.kotlin.h

/**
 * 动脑视频第二节 第一段视频: lsn2_0_Kotlin基础语法1_集合、扩展函数、扩展属性、vararg、infix、析构声明.vep
 */


fun test(i: Int = 100, j: String = "default!") {
    println("打印 i=$i,\t$j")
}

fun varargList(vararg list: Int) {  //不定长数组
    //item属于数组
    println("----------------------------")
    list.forEachIndexed { index, i -> println("下标：$index,\t条目：$i\t") }
}

//内联 - 扩展方法
inline fun String.show(str: String) {
    println("打印：$str")
}

//内联 - 扩展属性
inline val String.LastChar: Char
    get() = get(length - 1)

fun main(args: Array<String>) {
    val list = listOf(1, 2, -1, 4, 5, -9)

    println("打印：" + list[0])
    list.forEach { print("打印：$it,\t") }
    println()
    list.forEach { item ->
        print("打印：$item,\t")
    }
    println()
    //index 下标,i 条目
    list.forEachIndexed { index, i -> println("下标：$index\t条目：$i\t==\t" + list[index]) }
    println("-----------------")

    list.joinToString(postfix = "h=")

    test()
    test(1)
    test(j = "哈哈哈")
    test(10086, "hello")


    varargList(-1, -2, -3, -4, -5, -6, 1, 2, 3, 4, 5, 6)

    "".show("Hello Kotlin")
    println("你好".LastChar)


    val maps = mapOf(1 to "11", 2 to 22, 3 to "33", "last" to 44)
    println("打印,根据key：" + maps[1] + ",\t根据value：" + maps["last"])

    //中缀调用
    1 to "55"
    1.to("555")
    1 with "66"
    1.with("666")

    //析构声明
    val pair = "a" to "b"
    val (key, value) = pair

    //类似于截取
    val complie = "androidx.core:core-ktx:1.1.0-alpha05"
    val (group, name, version) = complie.split("-")
    println("group：$group")
    println("name：$name")
    println("version：$version")

}

//中缀调用
infix fun <A, B> A.with(that: B): Pair<A, B> = Pair(this, that)
