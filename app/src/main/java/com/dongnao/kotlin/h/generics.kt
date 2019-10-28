package com.dongnao.kotlin.h

/**
 * 泛型
 */

//泛型类
class ContainsIn<in T> {
    fun set(t: T) {

    }
}

//class ContainsOut<out T> {
//    fun set():T {
//
//    }
//}

//泛型方法
fun <T> Test(t: T) {

}

//泛型约束
fun <T : Number> put(t: T) {

}

interface OnClick
interface OnLongClick

//多个约束
fun <T> add(t: T) where T : OnClick, T : OnLongClick {

}

class Impl:OnClick,OnLongClick{

}

fun main(args: Array<String>) {

//    val list: ArrayList<*>=arrayListOf(1,2,4,5)
    put(1)
    add(Impl())
}