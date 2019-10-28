package com.dongnao.kotlin.rrd.ui.main

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import com.dongnao.kotlin.rrd.R
import com.dongnao.kotlin.rrd.RxSchedulerHelper
import com.dongnao.kotlin.rrd.base.BaseActivity
import com.dongnao.kotlin.rrd.api.GithubService
import com.dongnao.kotlin.rrd.api.baseUrl
import com.dongnao.kotlin.rrd.ui.searchuser.SearchUserActivity
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_main

    val titleList = arrayOf("搜索GitHub用户", "未知")


    override fun initView() {
        for (i in titleList.indices) {
            val button = AppCompatButton(this)
            button.text = titleList[i]
            button.textSize = 16f
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            button.layoutParams = params
            llcContainer.addView(button)
            button.onClick {
                startActivity(intentFor<SearchUserActivity>())
            }
        }

//        loadRetrofitRxJava2()

    }

    @SuppressLint("CheckResult")
    private fun loadRetrofitRxJava2() {
        val builder = OkHttpClient.Builder()
        val mHttpLoggingInterceptor = HttpLoggingInterceptor { message ->
            //            print(message)
        }
        mHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(mHttpLoggingInterceptor)

        val cache = Cache(File(""), (1024 * 1024 * 50).toLong())
        val client = builder.cache(cache)
            .connectTimeout(240, TimeUnit.SECONDS)
            .readTimeout(240, TimeUnit.SECONDS)
            .writeTimeout(240, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val githubService = retrofit.create(GithubService::class.java)

        githubService.getSearchUserList("tom")
            .compose(RxSchedulerHelper())
            .subscribe({
                println("输出数据--->>> ${it.toString()}")
            }, {
                println("打印异常--->>> ${it.message}")
            })
    }

}
