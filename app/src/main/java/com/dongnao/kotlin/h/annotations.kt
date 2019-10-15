package com.dongnao.kotlin.h


/**
 * 注解与反射
 */

@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ActivityLayout

@ActivityLayout
class Mainctivity(val name: String) {

}

@ActivityLayout
fun initView() {
    println("调用函数initView()：打印出成功!!")
}

var name = "1"

//反射
fun main(args: Array<String>) {
    //Class<?>
    String::class.java
    String.javaClass

    //函数、属性引用
    listOf(1, 2, 3).forEach(::println)

    val p = ::name
    p.set("10000")
    println("$p")

//    Mainctivity::name.get()

}




