package com.dongnao.kotlin.rrd.dagger2.modules

import com.dongnao.kotlin.rrd.dagger2.scopes.ActivityScope
import com.dongnao.kotlin.rrd.data.DataManager
import com.dongnao.kotlin.rrd.presenters.SearchUserPresenter
import com.dongnao.kotlin.rrd.ui.searchuser.SearchUserActivity
import dagger.Module
import dagger.Provides

/**
 * @author zhangshuai
 * @date 2019-10-17 18:45
 */

@Module
class ActivityModule(val activity: SearchUserActivity) {

    @ActivityScope
    @Provides
    fun provideSearchPresenter(dataManager: DataManager): SearchUserPresenter {
        return SearchUserPresenter(activity, dataManager)
    }

}