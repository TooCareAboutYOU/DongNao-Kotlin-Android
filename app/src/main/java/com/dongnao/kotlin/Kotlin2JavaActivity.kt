package com.dongnao.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    }

    //JNI定义native
    external fun java2Jni(x: Int, y: Int) :Int


}
