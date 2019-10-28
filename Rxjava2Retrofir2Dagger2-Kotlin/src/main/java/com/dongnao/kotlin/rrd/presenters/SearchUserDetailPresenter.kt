package com.dongnao.kotlin.rrd.presenters

import android.annotation.SuppressLint
import com.dongnao.kotlin.rrd.data.DataManager
import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author zhangshuai
 * @date 2019-10-18 18:04
 */

class SearchUserDetailPresenter(
    val views: GitHubPresenter.SearchUserDetailView,
    val dataManager: DataManager
) {
    @SuppressLint("CheckResult")
    fun getSearchUserDetail(username: String) {
        dataManager.getSearchUserDetail(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                views.startLoading()
            }.doOnError {
                views.stopLoading()
            }.doOnComplete {
                views.stopLoading()
            }
            .subscribe {
                views.getSearchUserDetailSuc(it)
            }
    }
}