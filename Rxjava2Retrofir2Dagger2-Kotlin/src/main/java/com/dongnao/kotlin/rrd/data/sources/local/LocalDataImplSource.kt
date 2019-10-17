package com.dongnao.kotlin.rrd.data.sources.local

import com.dongnao.kotlin.rrd.data.sources.DataImpl
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable

/**
 * @author zhangshuai
 * @date 2019-10-17 16:04
 */
class LocalDataImplSource : DataImpl.SearchUserPresenter {
    override fun getUserList(q: String): Flowable<BaseBean<List<ItemSearchUserListBean>>> {
        return Flowable.just(BaseBean<List<ItemSearchUserListBean>>())
    }
}