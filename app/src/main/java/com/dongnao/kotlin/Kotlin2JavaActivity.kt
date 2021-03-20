package com.dongnao.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dongnao.java.Utils

class Kotlin2JavaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin2_java)
        //使用有kotlin关键字为名字的方法或者属性
        Utils.`is`()
        Utils.`object`()
        Utils.array(intArrayOf(1, 2, 3))
        Utils.array2(*intArrayOf(1, 2, 3))


        Utils()()

        val j = Utils()
        j()

        //转义
        val i = Utils() as java.lang.Object
        i.wait()
        Case.compare("1", "2")
    }

    //JNI定义native
//    external fun java2Jni(x: Int, y: Int): Int

    object Case : Comparator<String> {
        override fun compare(o1: String?, o2: String?): Int {
            return o1!!.toInt() + o2!!.toInt()
        }

    }
}
