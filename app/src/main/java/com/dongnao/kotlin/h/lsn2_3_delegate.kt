package com.dongnao.kotlin.h

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 动脑视频第二节 第四段视频: lsn2_3_Kotlin基础语法4_数据类和委托.vep
 * 委托 替代继承的方式
 */
//委托类
class LocalList(clist: ArrayList<String>) : Collection<String> by clist {
    var p: String by Delegate()
}

//委托属性 懒加载
val list: ArrayList<String> by lazy {
    return@lazy ArrayList<String>()
}

//一定要是 var 修饰的可修改参数
var str1: String by Delegates.notNull<String>()

//观察者
var str2: String by Delegates.observable("100") { property, oldValue, newValue ->
    println("property= ${property.name}, oldValue= ${oldValue}, newValue= ${newValue}")
}

//有限制的
var str3: String by Delegates.vetoable("200") { property, oldValue, newValue ->
    //true：属性设置值新值替换旧值
    //false: 反之不替换
    println("打印：property= ${property.name}, oldValue= ${oldValue}, newValue= ${newValue}")
    true
}

//委托
class Delegates<T> : ReadWriteProperty<Any?, T> {
    var t: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        str3 = "3"
        println("打印：返回值")
        return t ?: throw NullPointerException("")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("打印：保存值 ${value}")
        this.t = value
    }

}

var param: String by Delegates()


fun main(args: Array<String>) {

    str2 = "123"
    println("打印str2：$str2")


    param = "321"// 等同于 setValue
    println("打印param：$param") //等同于 getValue


    println("打印str3：$str3")

    val list = arrayListOf("1,", "2", "3")
    val ll = LocalList(list)
    println("打印p: ${ll.p}")
    ll.p = "哈哈哈"
    println("打印p: ${ll.p}")

}


//自定义委托
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}