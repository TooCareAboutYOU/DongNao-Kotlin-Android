package com.dongnao.kotlin.h

/**
 * 动脑视频第二节 第四段视频: lsn2_3_Kotlin基础语法4_数据类和委托.vep
 * 数据类、构造器
 */

data class PresonBean(val name: String)

fun main(args: Array<String>) {
    Users("Hello")
    Users("Hello", "World")

}

//主构造器
class Users constructor(name: String) {
    var name2: String? = ""
    var pwd2: String? = ""

    //次构造器
    constructor(name: String, pwd: String) : this(name) {
        this.name2 = name
        this.pwd2 = pwd
    }

    //初始化器
    init {
        //主构造器传递过来的参数
        this.name2 = name
    }
}