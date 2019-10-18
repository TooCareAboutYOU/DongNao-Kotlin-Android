package com.dongnao.kotlin.rrd.data.retrofit2

import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author zhangshuai
 * @date 2019-10-17 16:27
 */

interface GithubService {

    @GET("search/users")
    fun getUserList(@Query("q") q: String): Flowable<BaseBean<ArrayList<ItemSearchUserListBean>>>
}