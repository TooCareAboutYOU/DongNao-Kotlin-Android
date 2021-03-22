package com.dongnao.kotlin.h


/**
 * 动脑视频第三节 第一段视频: lsn3_0_Kotlin高级特性1_lambda、操作符重载与协程.vep
 * 操作符重载
 */
fun main(args: Array<String>) {
    Rmb(1) + Rmb(2)


    Rmb(1) + 100
    Rmb(1).plus(100)
}

class Rmb(i: Int) {
    operator fun plus(rmb: Rmb) {

    }

    operator fun plus(rmb: Any?) {
    }
}

