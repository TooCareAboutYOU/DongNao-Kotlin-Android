package com.dongnao.app.kotlin.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.tmall.wireless.tangram.TangramBuilder
import com.tmall.wireless.tangram.TangramEngine
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

@SuppressLint("Registered")
abstract class BaseActivity<B : ViewDataBinding> : RxAppCompatActivity() {

    lateinit var mBinding: B

    abstract val layoutResId: Int

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutResId > 0) {
            mBinding = DataBindingUtil.setContentView(this@BaseActivity, layoutResId)
        } else {
            throw NullPointerException("the layoutResId is null")
        }
        init()
    }

    private fun createBuilder(): TangramBuilder.InnerBuilder = TangramBuilder.newInnerBuilder(this)

    fun getEngine(): TangramEngine = createBuilder().build()

}
