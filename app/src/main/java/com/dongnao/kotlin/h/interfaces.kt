package com.dongnao.kotlin.h

/**
 * 接口、抽象类、继承
 */
/**
 * **************************************接口**********************************
 */
interface OnCustomClickListener {
    val name: String
    fun click()
    fun test() {
        println("点击了接口，触发test函数")
    }
}

interface OnClickListener2 {
    fun click()
    fun test() {

    }
}

open class Button(override val name: String) : OnCustomClickListener, OnClickListener2 {
    override fun test() {
        super<OnCustomClickListener>.test()
    }

    override fun click() {

    }

    open fun show(){

    }
}


/**
 * **************************************抽象类**********************************
 */

class DNButton(override val name: String) : Button(name) {
    override fun test() {

    }

    override fun click() {

    }

    override fun show() {
        super.show()
    }
}

abstract class Person {
    abstract fun test()
}

class Main : Person() {
    override fun test() {

    }

}

