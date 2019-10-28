package com.dongnao.kotlin.rrd.data.impl

import com.dongnao.kotlin.rrd.data.IViews
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable


interface GitHubPresenter {

    fun getSearchUserList(q: String): Flowable<BaseBean<ArrayList<ItemSearchUserListBean>>>
    fun getSearchUserDetail(username: String): Flowable<BaseBean<ItemSearchUserListBean>>


    interface SearchUserListView : IViews {
        fun getSearchUserListSuc(data: ArrayList<ItemSearchUserListBean>)
    }

    interface SearchUserDetailView : IViews {
        fun getSearchUserDetailSuc(data: ItemSearchUserListBean)
    }
}
