package com.dongnao.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import com.dongnao.kotlin.widgets.MyView
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.db.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class SplashActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //xml格式布局
//        loadXML()

        //DSL格式布局
        loadDSL()
    }


    private fun loadXML() {
        setContentView(R.layout.activity_splash)
        acBtnClick.setOnClickListener {
            val countries = listOf("China", "Russia", "USA", "Japan", "Australia")
            val title = "Where are you from："
            selector(title, countries) { dialogInterface, i ->
                alert("Hi, I'm Roy", title) {
                    yesButton {
                        info("选中了第" + i + "个为 " + countries[i])
                        info { "选中了第" + i + "个为 " + countries[i] }
                        dialogInterface.dismiss()
                    }
                    noButton {}
                }.show()
            }

        }
        dip(10)
        acBtnClick.textSize = px2dip(40)
    }

    private fun loadDSL() {
        verticalLayout {
            val name = editText()
            button("请点击") {
                onClick { toast("响应成功：${name.text}") }
            }
            MyView {
                test()
            }
            MyView(this@SplashActivity).onClick {
                toast("触发成功！")
            }
        }
    }
}

//预览SplashActivity
class SplashActivityUI : AnkoComponent<SplashActivity> {
    override fun createView(ui: AnkoContext<SplashActivity>) = with(ui) {
        verticalLayout {
            val name = editText()
            button("请点击") {
                onClick { toast("响应成功：${name.text}") }
            }
            MyView {
                test()
            }
        }
    }
}
