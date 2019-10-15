package com.dongnao.kotlin.widgets

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView


//内联 + lambda表达式参数形式
inline fun ViewManager.MyView(init: MyView.() -> Unit = {}): MyView {
    return ankoView({ MyView(it) }, theme = 0, init = init)
}

class MyView(context: Context) : View(context) {

    public fun test(){
        println("MyView 调用成功！！")
    }
}