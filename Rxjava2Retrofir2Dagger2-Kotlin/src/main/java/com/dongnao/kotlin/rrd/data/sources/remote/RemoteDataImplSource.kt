package com.dongnao.kotlin.rrd.data.sources.remote

import com.dongnao.kotlin.rrd.RxSchedulerHelper
import com.dongnao.kotlin.rrd.data.retrofit2.GithubService
import com.dongnao.kotlin.rrd.data.sources.DataImpl
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author zhangshuai
 * @date 2019-10-17 16:04
 */

class RemoteDataImplSource(val githubService: GithubService) : DataImpl.SearchUserListPresenter {

    override fun getUserList(q: String): Flowable<BaseBean<ArrayList<ItemSearchUserListBean>>> {
        return githubService.getUserList(q).compose(RxSchedulerHelper())
    }

}