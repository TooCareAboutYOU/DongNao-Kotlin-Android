package com.dongnao.kotlin.rrd.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : RxAppCompatActivity() {
    /**
     * 获取xml布局索引
     */
    abstract fun setLayoutId(): Int

    /**
     * 初始化View-Data
     */
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initView()
    }

}