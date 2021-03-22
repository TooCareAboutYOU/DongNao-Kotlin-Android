package com.dongnao.kotlin.h

import android.text.TextUtils


/**
 * 动脑视频第二节 第二段视频: lsn2_1_Kotlin基础语法2_字符串、正则表达式、null安全与本地函数.vep
 */

fun main(args: Array<String>) {
    test(null)
}

fun test(str: String?) {
    str?.substring(0)
    str!!.substring(0) //不安全,需开发者自己保证不为 null
}


//本地函数
class User(val id: Int, val name: String, val pwd: String)

//模拟保存到数据库
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

