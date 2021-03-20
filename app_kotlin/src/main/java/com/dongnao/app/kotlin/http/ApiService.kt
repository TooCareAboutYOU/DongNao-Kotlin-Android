package com.dongnao.app.kotlin.http

import com.dongnao.app.kotlin.common.baseUrl
import com.dongnao.app.kotlin.model.PublishedDate
import com.dongnao.app.kotlin.model.Result
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

/**
 * @author zhangshuai
 * @date 2019-10-28 10:28
 */

interface ApiService {

    //初始化Retrofit
    companion object Factory {
        fun create(): ApiService {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(120L, TimeUnit.SECONDS)
                .readTimeout(120L, TimeUnit.SECONDS)
                .writeTimeout(120L, TimeUnit.SECONDS)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl())
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }


    //分类
    @GET("api/data/{type}/{pageSize}/{pageNumber}")
    fun getData(
        @Path("type") type: String,
        @Path("pageSize") pageSize: Int,
        @Path("pageNumber") pageNumber: Int
    ): Observable<Result>


    //获取最新一天的干货  http://gank.io/api/today
    @GET("api/{day}")
    fun getNewData(@Path("day") day: String): Observable<Result>


    @GET("api/day/{year}/{month}/{day}")
    fun getEveryDayData(
        @Path("year") year: String,
        @Path("month") month: String,
        @Path("day") day: String
    ): Observable<ResponseBody>


    //每日数据： http://gank.io/api/day/年/月/日
    @GET("api/day/{date}")
    fun getEveryDayData(@Path("date") date: String): Observable<ResponseBody>

    //获取某几日干货网站数据:  http://gank.io/api/history/content/2/1
    //获取特定日期网站数据:  http://gank.io/api/history/content/day/2016/05/11
    @GET("api/history/content/{date}")
    fun getSomeDays(@Path("date") date: String): Observable<ResponseBody>


    //获取发过干货日期接口:
    @GET("api/day/history")
    fun getPublishedDate(): Observable<PublishedDate>

    //获取历史记录 http://gank.io/history
    @GET("history")
    fun getHistory(): Observable<ResponseBody>

}