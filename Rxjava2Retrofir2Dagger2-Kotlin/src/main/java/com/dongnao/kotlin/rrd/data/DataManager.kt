package com.dongnao.kotlin.rrd.data

import com.dongnao.kotlin.rrd.data.sources.DataImpl
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable
import javax.inject.Inject


class DataManager @Inject constructor(val remote: DataImpl.SearchUserPresenter, val local: DataImpl.SearchUserPresenter) {

    fun getUserData(q: String): Flowable<List<ItemSearchUserListBean>> {
        return remote.getUserList(q).onExceptionResumeNext(local.getUserList(q)).map { it.items }
    }

}