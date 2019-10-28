package com.dongnao.kotlin.rrd.dagger2.modules

import com.dongnao.kotlin.rrd.dagger2.scopes.Local
import com.dongnao.kotlin.rrd.dagger2.scopes.Remote
import com.dongnao.kotlin.rrd.data.DataManager
import com.dongnao.kotlin.rrd.api.GithubService
import com.dongnao.kotlin.rrd.dagger2.scopes.ActivityScope
import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import com.dongnao.kotlin.rrd.data.impl.local.LocalDataImplSource
import com.dongnao.kotlin.rrd.data.impl.remote.RemoteDataImplSource
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
    fun provideRemotePresenter(githubService: GithubService): GitHubPresenter {
        return RemoteDataImplSource(githubService)
    }

    @Singleton
    @Local
    @Provides
    fun provideLocalPresenter(): GitHubPresenter {
        return LocalDataImplSource()
    }

    @Singleton
    @Provides
    fun provideDataManager(@Remote remote: GitHubPresenter, @Local local: GitHubPresenter
    ): DataManager {
        return DataManager(remote, local)
    }
}