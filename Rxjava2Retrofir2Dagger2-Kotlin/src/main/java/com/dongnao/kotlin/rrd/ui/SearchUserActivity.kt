package com.dongnao.kotlin.rrd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dongnao.kotlin.rrd.R
import com.dongnao.kotlin.rrd.base.BaseActivity
import com.dongnao.kotlin.rrd.data.sources.DataImpl
import com.dongnao.kotlin.rrd.presenters.SearchUserPresenter
import kotlinx.android.synthetic.main.activity_search_user.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import javax.inject.Inject

class SearchUserActivity : BaseActivity() {

    @Inject lateinit var  prsenter: SearchUserPresenter

    override fun setLayoutId() = R.layout.activity_search_user

    override fun initView() {
        recyclerViewSearch.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        acTvGoSearch.onClick {
            val q: String = acEtSearchInfo.text.toString().trim()
        }
    }
}
