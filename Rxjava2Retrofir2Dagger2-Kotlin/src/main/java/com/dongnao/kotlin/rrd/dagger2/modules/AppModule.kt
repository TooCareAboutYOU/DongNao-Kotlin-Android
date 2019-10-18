package com.dongnao.kotlin.rrd.dagger2.modules

import com.dongnao.kotlin.rrd.dagger2.scopes.Local
import com.dongnao.kotlin.rrd.dagger2.scopes.Remote
import com.dongnao.kotlin.rrd.data.DataManager
import com.dongnao.kotlin.rrd.data.retrofit2.GithubService
import com.dongnao.kotlin.rrd.data.sources.DataImpl
import com.dongnao.kotlin.rrd.data.sources.local.LocalDataImplSource
import com.dongnao.kotlin.rrd.data.sources.remote.RemoteDataImplSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author zhangshuai
 * @date 2019-10-17 16:56
 */

@Module(includes = arrayOf(RetrofitModule::class))
class AppModule {

    @Singleton
    @Remote
    @Provides
    fun provideRemotePresenter(githubService: GithubService): DataImpl.SearchUserListPresenter {
        return RemoteDataImplSource(githubService)
    }

    @Singleton
    @Local
    @Provides
    fun provideLocalPresenter(): DataImpl.SearchUserListPresenter {
        return LocalDataImplSource()
    }

    @Singleton
    @Provides
    fun provideDataManager(
        @Remote remote: DataImpl.SearchUserListPresenter,
        @Local local: DataImpl.SearchUserListPresenter
    ): DataManager {
        return DataManager(remote, local)
    }
}