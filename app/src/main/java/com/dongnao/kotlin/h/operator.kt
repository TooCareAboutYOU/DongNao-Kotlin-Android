package com.dongnao.kotlin.h

/**
 * 操作符重载
 */

fun main(args: Array<String>) {
    Rmb(1)+Rmb(2)

}

class Rmb(i: Int) {
    operator fun plus(rmb: Rmb) {
    }
}

