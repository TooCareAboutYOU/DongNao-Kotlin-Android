package com.dongnao.kotlin.rrd.presenters

import android.annotation.SuppressLint
import com.dongnao.kotlin.rrd.data.DataManager
import com.dongnao.kotlin.rrd.data.sources.DataImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SearchUserPresenter(
    val views: DataImpl.SearchUserListPresenter.UserListView,
    val dataManager: DataManager
) {
    @SuppressLint("CheckResult")
    fun getUsersList(q: String) {
        dataManager.getUserData(q)
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
                views.getUserListSuc(it)
            }
    }

}