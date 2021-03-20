//@file:JvmName("Utils")
//@file:JvmMultifileClass
//
//package com.dongnao.kotlin.a
//
//import androidx.core.graphics.component1
//import androidx.core.graphics.component2
//import kotlin.reflect.KProperty
//
//class b {
//    fun <T> MutableList<T>.swap(x: Int, y: Int): T {
//        val temp = this[x]
//        this[x] = this[y]
//        this[y] = temp
//        return this[y]
//    }
//
//    fun Any?.toString(): String {
//        if (this == null) {
//            return "null"
//        }
//        return toString()
//    }
//
//    /** 中缀符号
//     * 1 swap 2
//     * 1.swap(2)
//     */
//    infix fun Int.swap(value: Int): String {
//        return value.toString()
//    }
//
//    /** 命名函数
//     * 1、默认函数 reformat("打印：")
//     * 2、非默认函数 reformat("打印：",true,true,true,'_')
//     * 3、部分参数  reformat()
//     */
//    fun reformat(
//        str: String,
//        normalizeCase: Boolean = true,
//        upperCaseFirstLetter: Boolean = true,
//        divideByCamelHumps: Boolean = false,
//        wordSeparator: Char = ' '
//    ) {
//        //多重声明
//        val (name, agr) = sum(1, 2)
//        val collection = mapOf("name" to "Tom", "age" to 18)
//        for ((key, value) in collection.Iterator()) {
//            println("输出key：$key, value：$value")
//        }
//    }
//
//    val sum = { x: Int, y: Int -> x + y }
//}
//
//fun <K, V> Map<out K, V>.Iterator(): Iterator<Map.Entry<K, V>> = entries.iterator()
//
//
//
//
//
//
