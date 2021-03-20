package com.dongnao.app.kotlin.app

import android.app.Application
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.tmall.wireless.tangram.TangramBuilder
import com.tmall.wireless.tangram.util.IInnerImageSetter

/**
 * @author zhangshuai
 * @date 2019-11-26 10:47
 */

class MyKotlinApplication : Application(), IInnerImageSetter {

    //全局初始化Tangram一次，提供一个通用的图片加载器
    override fun <IMAGE : ImageView?> doLoadImageUrl(view: IMAGE, url: String?) {
//        Glide.with(view!!.context).load(url).into(view)
    }

    override fun onCreate() {
        super.onCreate()
        TangramBuilder.init(this, this, AppCompatImageView::class.java)
    }
}
