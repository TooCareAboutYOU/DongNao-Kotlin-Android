package com.dongnao.kotlin.rrd.ui

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dongnao.kotlin.rrd.R
import com.dongnao.kotlin.rrd.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sp
import org.jetbrains.anko.toast


class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_main

    val titleList = arrayOf("搜索GitHub用户","未知")

    override fun initView() {
        for (i in titleList.indices){
            val button = AppCompatButton(this)
            button.text=titleList[i]
            button.textSize= 16f
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            button.layoutParams = params
            llcContainer.addView(button)
            button.onClick {
                startActivity(intentFor<SearchUserActivity>())
            }
        }
    }
}
