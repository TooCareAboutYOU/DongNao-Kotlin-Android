package com.dongnao.kotlin.rrd.app

import android.app.Application
import com.dongnao.kotlin.rrd.dagger2.components.AppComponent
import com.dongnao.kotlin.rrd.dagger2.components.DaggerAppComponent
import com.dongnao.kotlin.rrd.dagger2.modules.AppModule

/**
 * @author zhangshuai
 * @date 2019-10-17 16:42
 */

class GitHubApplication : Application() {

    companion object {
        lateinit private var instance: GitHubApplication
        fun getInstance(): GitHubApplication {
            return instance
        }
    }

    lateinit private var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    fun getAppComponent(): AppComponent = appComponent
}