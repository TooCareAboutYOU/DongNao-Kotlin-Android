package com.dongnao.kotlin.rrd.data.impl.local

import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import com.dongnao.kotlin.rrd.model.BaseBean
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import io.reactivex.Flowable

/**
 * @author zhangshuai
 * @date 2019-10-17 16:04
 */
class LocalDataImplSource : GitHubPresenter {
    override fun getSearchUserList(q: String): Flowable<BaseBean<ArrayList<ItemSearchUserListBean>>> {
        return Flowable.just(BaseBean<ArrayList<ItemSearchUserListBean>>())
    }

    override fun getSearchUserDetail(username: String): Flowable<BaseBean<ItemSearchUserListBean>> {
        return Flowable.just(BaseBean<ItemSearchUserListBean>())
    }
}