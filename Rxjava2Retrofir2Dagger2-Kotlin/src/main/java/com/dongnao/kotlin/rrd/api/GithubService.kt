package com.dongnao.kotlin.rrd.api

import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author zhangshuai
 * @date 2019-10-17 16:27
 */

/**
 *retrofit
 */
const val baseUrl: String = "https://api.github.com/"


interface GithubService {
    /**
     * 用户列表
     */
    @GET("search/users")
    fun getSearchUserList(@Query("q") q: String): Flowable<BaseBean<ArrayList<ItemSearchUserListBean>>>

    /**
     * 用户详细信息
     */
    @GET("users/{username}")
    fun getSearchUserDetail(@Path("username") username: String): Flowable<BaseBean<ItemSearchUserListBean>>

}