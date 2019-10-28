package com.dongnao.kotlin.rrd.data

import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable
import javax.inject.Inject


class DataManager @Inject constructor(
    val remote: GitHubPresenter,
    val local: GitHubPresenter
) {

    fun getSearchUserList(q: String): Flowable<ArrayList<ItemSearchUserListBean>> {
        return remote.getSearchUserList(q)
            .onExceptionResumeNext(local.getSearchUserList(q))
            .map { it.items }
    }

    fun getSearchUserDetail(username: String): Flowable<ItemSearchUserListBean> {
        return remote.getSearchUserDetail(username)
            .onExceptionResumeNext(local.getSearchUserDetail(username))
            .map { it.items }
    }


}