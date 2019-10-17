package com.dongnao.kotlin.rrd.data.sources

import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable


interface DataImpl {
    interface SearchUserPresenter{

        interface UserListView{
            fun getUserListSuc(): Flowable<List<ItemSearchUserListBean>>
        }

        fun getUserList(q: String): Flowable<BaseBean<List<ItemSearchUserListBean>>>
    }

}