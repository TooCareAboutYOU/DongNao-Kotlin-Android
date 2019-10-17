package com.dongnao.kotlin.rrd.data.sources.remote

import com.dongnao.kotlin.rrd.data.retrofit2.GithubService
import com.dongnao.kotlin.rrd.data.sources.DataImpl
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable

/**
 * @author zhangshuai
 * @date 2019-10-17 16:04
 */

class RemoteDataImplSource(val githubService: GithubService) : DataImpl.SearchUserPresenter {

    override fun getUserList(q: String): Flowable<BaseBean<List<ItemSearchUserListBean>>> {
        return githubService.getUserList(q)
    }


}