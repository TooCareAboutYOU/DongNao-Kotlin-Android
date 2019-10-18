package com.dongnao.kotlin.rrd.dagger2.modules

import android.annotation.SuppressLint
import com.dongnao.kotlin.rrd.data.retrofit2.GithubService
import com.dongnao.kotlin.rrd.model.baseUrl
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author zhangshuai
 * @date 2019-10-17 17:14
 */

@Module
class RetrofitModule {

    @SuppressLint("CheckResult")
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
//        val builder = OkHttpClient.Builder()
//        val mHttpLoggingInterceptor = HttpLoggingInterceptor { message ->
//                        print(message)
//        }
//        mHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        builder.addInterceptor(mHttpLoggingInterceptor)
//
//        val cache = Cache(File(""), (1024 * 1024 * 50).toLong())
//        val client = builder.cache(cache)
//            .connectTimeout(240, TimeUnit.SECONDS)
//            .readTimeout(240, TimeUnit.SECONDS)
//            .writeTimeout(240, TimeUnit.SECONDS)
//            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
//            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit
    }

    @Singleton
    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}