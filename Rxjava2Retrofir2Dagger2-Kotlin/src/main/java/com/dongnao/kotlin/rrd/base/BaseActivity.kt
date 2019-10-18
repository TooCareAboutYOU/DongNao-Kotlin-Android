package com.dongnao.kotlin.rrd.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dongnao.kotlin.rrd.app.GitHubApplication
import com.dongnao.kotlin.rrd.dagger2.components.AppComponent
import com.dongnao.kotlin.rrd.dagger2.components.DaggerActivityComponent
import com.dongnao.kotlin.rrd.dagger2.modules.ActivityModule
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog
import javax.inject.Inject

abstract class BaseActivity : RxAppCompatActivity() {

    var progressDialog: ProgressDialog? = null

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
        setAppComponent(GitHubApplication.getInstance().getAppComponent())
        initView()
    }

    open fun setAppComponent(appComponent: AppComponent) {

    }

    open fun startLoading() {
        if (progressDialog === null) {
            progressDialog = indeterminateProgressDialog("正在加载...")
        } else {
            progressDialog?.show()
        }
    }

    open fun stopLoading() {
        progressDialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLoading()
        progressDialog = null
    }

}