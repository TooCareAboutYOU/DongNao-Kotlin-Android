package com.dongnao.kotlin.app

import android.app.Application
import kotlin.properties.Delegates


class KotlinApplication : Application() {

    companion object {
        /**
         * 方式一： 代理 可以作用在用 var val 声明的 instances
         */
//        private var instances: KotlinApplication by Delegates.notNull()

        /**
         * 方式二：lateinit只能作用在 var 声明的 instances
         */
        lateinit private var instances: KotlinApplication

        fun getApplication(): KotlinApplication = instances
    }

    override fun onCreate() {
        super.onCreate()
        instances = this
    }

}