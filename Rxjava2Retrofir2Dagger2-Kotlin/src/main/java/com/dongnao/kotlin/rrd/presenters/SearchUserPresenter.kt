package com.dongnao.kotlin.rrd.presenters

import android.annotation.SuppressLint
import com.dongnao.kotlin.rrd.data.DataManager
import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SearchUserPresenter(
    val views: GitHubPresenter.SearchUserListView,
    val dataManager: DataManager
) {
    @SuppressLint("CheckResult")
    fun getUsersList(q: String) {
        dataManager.getSearchUserList(q)
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
                views.getSearchUserListSuc(it)
            }
    }

}