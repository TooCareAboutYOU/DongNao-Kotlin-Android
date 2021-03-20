package com.dongnao.kotlin.rrd.dagger2.components

import com.dongnao.kotlin.rrd.dagger2.modules.ActivityModule
import com.dongnao.kotlin.rrd.dagger2.scopes.ActivityScope
import com.dongnao.kotlin.rrd.ui.searchuser.SearchUserActivity
import com.dongnao.kotlin.rrd.ui.searchuserdetail.SearchUserDetailActivity
import dagger.Component

/**
 * @author zhangshuai
 * @date 2019-10-17 18:33
 */

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(searchUserActivity: SearchUserActivity)

    fun inject(searchUserDetailActivity: SearchUserDetailActivity)

}