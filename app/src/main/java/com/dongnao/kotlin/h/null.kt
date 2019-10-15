package com.dongnao.kotlin.h

import android.text.TextUtils


fun main(args: Array<String>) {
    test(null)
}

fun test(str: String?) {
    str?.substring(0)
    str!!.substring(0) //不安全,需开发者自己保证不为 null
}


//本地函数
class User(val id: Int, val name: String, val pwd: String)

//存库
fun User.save() {
    //声明函数
    fun check(str: String?) {

        if (!TextUtils.isEmpty(str)) {
            //do something
        }
    }
    check(name)

    //声明类
    class Custom

}

