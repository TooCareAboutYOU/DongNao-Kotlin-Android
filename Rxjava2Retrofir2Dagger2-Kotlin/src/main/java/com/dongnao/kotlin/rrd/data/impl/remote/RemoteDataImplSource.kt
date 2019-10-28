package com.dongnao.kotlin.rrd.data.impl.remote

import com.dongnao.kotlin.rrd.RxSchedulerHelper
import com.dongnao.kotlin.rrd.api.GithubService
import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable

/**
 * @author zhangshuai
 * @date 2019-10-17 16:04
 */

class RemoteDataImplSource(val githubService: GithubService) : GitHubPresenter {

    override fun getSearchUserDetail(username: String): Flowable<BaseBean<ItemSearchUserListBean>> {
        return githubService.getSearchUserDetail(username).compose(RxSchedulerHelper())
    }

    override fun getSearchUserList(q: String): Flowable<BaseBean<ArrayList<ItemSearchUserListBean>>> {
        return githubService.getSearchUserList(q).compose(RxSchedulerHelper())
    }

}