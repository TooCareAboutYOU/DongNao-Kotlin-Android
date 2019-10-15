package com.dongnao.kotlin.h

/**
 * 数据类、构造器
 */

data class PresonBean(val name: String)

fun main(args: Array<String>) {
    Users("Hello")

}

class Users constructor(name: String) {
    var name2: String = ""
    var pwd2: String = ""

    //初始化器
    init {
        this.name2=name
    }

    constructor(name: String, pwd: String) : this(name) {
        this.name2 = name
        this.pwd2 = pwd
    }
}