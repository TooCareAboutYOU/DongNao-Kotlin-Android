package com.dongnao.kotlin.rrd.dagger2.components

import com.dongnao.kotlin.rrd.dagger2.modules.AppModule
import com.dongnao.kotlin.rrd.dagger2.modules.RetrofitModule
import com.dongnao.kotlin.rrd.data.DataManager
import dagger.Component
import javax.inject.Singleton

/**
 * @author zhangshuai
 * @date 2019-10-17 16:50
 */

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {

    fun dataManage(): DataManager

}