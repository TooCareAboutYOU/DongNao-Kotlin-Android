package com.dongnao.kotlin.h

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 委托 替代继承的方式
 */
class LocalList(list: ArrayList<String>) : Collection<String> by list {

}

//
val list: ArrayList<String> by lazy {
    ArrayList<String>()
}

var str1: String by Delegates.notNull<String>()

var str2: String by Delegates.observable("") { property, oldValue, newValue ->
    println("${property.name}\told:${oldValue}\tnewV:${newValue}")
}

var str3: String by Delegates.vetoable("") { property, oldValue, newValue ->
    false
}

class Delegates<T> : ReadWriteProperty<Any?, T> {
    var t: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return t ?: throw NullPointerException("")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.t = value
    }

}

var p: String by Delegates()
