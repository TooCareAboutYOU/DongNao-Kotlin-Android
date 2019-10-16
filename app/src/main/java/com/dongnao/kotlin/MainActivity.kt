package com.dongnao.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.dongnao.java.Java2KotlinActivity
import kotlinx.coroutines.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) = when (v?.id) {
        R.id.acBtn_Click -> {
            toast("跳转到 SplashActivitySplashActivity")
            startActivity(intentFor<SplashActivity>())
        }
        R.id.acBtn_Layout -> {
            startActivity(intentFor<AnkoLayoutActivity>())
        }
        R.id.acBtn_Db -> {
            startActivity(intentFor<DataBaseActivity>())
        }
        R.id.acBtn_Java2Kotlin->{
            startActivity(intentFor<Java2KotlinActivity>())
        }
        R.id.acBtn_Kotlin2Java->{
            startActivity(intentFor<Kotlin2JavaActivity>())
        }
        else -> {

        }
    }

    @BindView(R.id.acBtn_Click) lateinit var acBtnClick: AppCompatButton
    @BindView(R.id.acBtn_Layout) lateinit var acBtnLayout: AppCompatButton
    @BindView(R.id.acBtn_Db) lateinit var acBtnDb: AppCompatButton
    @BindView(R.id.acBtn_Java2Kotlin) lateinit var acBtJava2Kotlin: AppCompatButton
    @BindView(R.id.acBtn_Kotlin2Java) lateinit var acBtKotlin2Java: AppCompatButton

    var unbinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this)
//        init()
        acBtnClick.text = stringFromJNI()
        //方式一
        acBtnClick.setOnClickListener(this)
        //方式二
//        textView.setOnClickListener{ toast("Anko引用成功！！！哈哈哈") }

        acBtnLayout.setOnClickListener(this)
        acBtnDb.setOnClickListener(this)
        acBtJava2Kotlin.setOnClickListener(this)
        acBtKotlin2Java.setOnClickListener(this)
    }


    private fun init() {
        acBtnClick.text = stringFromJNI()
        //生命周期是整个应用程序的生命周期
        var job = GlobalScope.launch {
            delay(3000L)
            println("在延迟后打印输出")
            runOnUiThread {
                acBtnClick.text = "Hello Kotlin!"
            }
        }
        println("协程已在等待时主线程还在继续")
        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
        job.cancel()
        var a = GlobalScope.async {
            delay(1000L)
            println("asyn")
        }

    }


    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder!!.unbind()
    }
}

