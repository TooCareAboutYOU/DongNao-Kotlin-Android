package com.dongnao.kotlin.rrd.ui.searchuserdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.dongnao.kotlin.rrd.R
import com.dongnao.kotlin.rrd.USER_NAME
import com.dongnao.kotlin.rrd.base.BaseActivity
import com.dongnao.kotlin.rrd.dagger2.components.AppComponent
import com.dongnao.kotlin.rrd.dagger2.modules.ActivityModule
import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import com.dongnao.kotlin.rrd.presenters.SearchUserDetailPresenter
import javax.inject.Inject

class SearchUserDetailActivity : BaseActivity(), GitHubPresenter.SearchUserDetailView {

//    @Inject
//    lateinit val dataManager: SearchUserDetailPresenter

    override fun setLayoutId(): Int = R.layout.activity_search_user_detail

//    override fun setAppComponent(appComponent: AppComponent) {
//        DaggerActivityComponent.builder()
//            .appComponent(appComponent)
//            .build()
//            .inject(this)
//    }

    override fun initView() {

        val username = intent.getStringExtra(USER_NAME)


    }


    override fun getSearchUserDetailSuc(data: ItemSearchUserListBean) {

    }

}
