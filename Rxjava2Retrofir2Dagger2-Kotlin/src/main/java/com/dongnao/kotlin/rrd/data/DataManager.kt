package com.dongnao.kotlin.rrd.data

import com.dongnao.kotlin.rrd.data.sources.DataImpl
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class DataManager @Inject constructor(
    val remote: DataImpl.SearchUserListPresenter,
    val local: DataImpl.SearchUserListPresenter
) {

    fun getUserData(q: String): Flowable<ArrayList<ItemSearchUserListBean>> {
        return remote.getUserList(q)
            .onExceptionResumeNext(local.getUserList(q))
            .map { it.items }
    }

}