package com.dongnao.kotlin.h

/**
 * 动脑视频第二节 第三段视频:  lsn2_2_Kotlin基础语法3_接口、类与访问控制.vep
 */
/**
 * **************************************接口**********************************
 */
interface OnCustomClickListener {
    val name: String
    fun click()
    fun test() {
        println("点击了OnCustomClickListener接口，触发test函数")
    }
}

interface OnClickListener2 {
    fun click()
    fun test() {
        println("点击了OnClickListener2接口，触发test函数")
    }
}

//name抽象的属性
open class Button(override val name: String) : OnCustomClickListener, OnClickListener2 {
    override fun test() {
        println("点击了Button，触发test函数， $name")
        super<OnClickListener2>.test()
    }

    override fun click() {

    }

    //新增
    open fun show(){

    }
}


fun main(args: Array<String>) {
    val btn = Button("Hello")
    btn.test()
}


/**
 * **************************************抽象类**********************************
 */

class DNButton(override val name: String) : Button(name) {
    override fun test() {

    }

    override fun click() {

    }

}

abstract class Person {
    abstract fun test()
}

class Main : Person() {
    override fun test() {

    }

}

