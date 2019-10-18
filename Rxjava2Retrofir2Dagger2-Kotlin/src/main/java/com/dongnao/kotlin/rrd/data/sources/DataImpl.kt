package com.dongnao.kotlin.rrd.data.sources

import com.dongnao.kotlin.rrd.data.IViews
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable


interface DataImpl {
    interface SearchUserListPresenter {

        interface UserListView : IViews {
            fun getUserListSuc(data: ArrayList<ItemSearchUserListBean>)
        }

        fun getUserList(q: String): Flowable<BaseBean<ArrayList<ItemSearchUserListBean>>>
    }

}