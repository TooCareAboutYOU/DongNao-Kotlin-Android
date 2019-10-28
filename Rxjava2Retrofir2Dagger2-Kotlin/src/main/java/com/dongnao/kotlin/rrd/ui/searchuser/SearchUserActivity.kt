package com.dongnao.kotlin.rrd.ui.searchuser

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dongnao.kotlin.rrd.R
import com.dongnao.kotlin.rrd.base.BaseActivity
import com.dongnao.kotlin.rrd.dagger2.components.AppComponent
import com.dongnao.kotlin.rrd.dagger2.components.DaggerActivityComponent
import com.dongnao.kotlin.rrd.dagger2.modules.ActivityModule
import com.dongnao.kotlin.rrd.data.impl.GitHubPresenter
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import com.dongnao.kotlin.rrd.presenters.SearchUserPresenter
import kotlinx.android.synthetic.main.activity_search_user.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import javax.inject.Inject

class SearchUserActivity : BaseActivity(), GitHubPresenter.SearchUserListView {

    @Inject
    lateinit var presenter: SearchUserPresenter

    val adapter: SearchUserAdapter = SearchUserAdapter(this)

    override fun setLayoutId() = R.layout.activity_search_user

    override fun setAppComponent(appComponent: AppComponent) {
        DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }

    override fun initView() {
        recyclerViewSearch.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        recyclerViewSearch.adapter = adapter
        acTvGoSearch.onClick {
            presenter.getUsersList("tom")
        }
    }

    override fun getSearchUserListSuc(data: ArrayList<ItemSearchUserListBean>) {
        adapter.update(data)
    }
}
