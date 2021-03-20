package com.dongnao.app.kotlin.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dongnao.app.kotlin.R
import com.dongnao.app.kotlin.base.BaseFragment
import com.dongnao.app.kotlin.databinding.FragmentHistoryBinding
import com.dongnao.app.kotlin.http.ApiService
import com.dongnao.app.kotlin.model.History
import com.dongnao.app.kotlin.ui.activity.MainActivity
import com.dongnao.app.kotlin.ui.adapters.HistoryAdapter
import com.dongnao.app.kotlin.utils.dismissProgress
import com.dongnao.app.kotlin.utils.showProgress
import com.dongnao.app.kotlin.utils.toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_history.view.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException


/**
 * @author zhangshuai
 * @date 2019-10-28 11:42
 */

class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {

    private var activity: MainActivity? = null
    private var list: MutableList<History>? = arrayListOf()
    private var adapter: HistoryAdapter? = null

    //伴生对象
    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }

    override val layoutResId: Int
        get() = R.layout.fragment_history


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.activity = context as MainActivity?
    }

    override fun init() {
        rootView.recyclerView.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rootView.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                RecyclerView.VERTICAL
            )
        )
        adapter = HistoryAdapter(R.layout.item_history, list)
        rootView.recyclerView.adapter = adapter
        adapter?.setOnItemClickListener { adapter, view, position -> activity?.toast("Click $position") }
        rootView.swipeRefresh.setColorSchemeColors(Color.rgb(47, 223, 189))
        rootView.swipeRefresh.setOnRefreshListener {
            list?.clear()
            loadHistory()
        }
        loadHistory()
    }


    //获取数据，并刷新界面
    @SuppressLint("CheckResult")
    private fun loadHistory() {
        println("访问网络")
        activity?.showProgress()
        ApiService.create()
            .getHistory()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({ it ->
                println("数据处理：")
                val source = it.source()
                try {
                    source.request(java.lang.Long.MAX_VALUE)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                val buffer = source.buffer
                var charset = Charset.defaultCharset()
                val contentType = it.contentType()
                if (contentType != null) {
                    try {
                        charset = contentType.charset(Charset.defaultCharset())
                    } catch (e: UnsupportedCharsetException) {
                        e.printStackTrace()
                    }
                }
                val str = buffer.clone().readString(charset)
                println("输出 $str")
                loadAdapter(parseHtml(str))
            }, {
                println("输出异常： ${it.message}")
                activity?.dismissProgress()
            })
    }


    private fun loadAdapter(data: MutableList<History>) {
        list?.addAll(data)
        adapter?.notifyDataSetChanged()
        activity?.dismissProgress()
        if (rootView.swipeRefresh.isRefreshing) {
            rootView.swipeRefresh.isRefreshing = false
        }
    }

    //解析Html
    private fun parseHtml(html: String): MutableList<History> {
        val doc: Document = Jsoup.parse(html)
        val typo: Elements = doc.getElementsByClass("typo")
        val data: MutableList<History> = arrayListOf()
        typo.select("a").listIterator().forEach {
            println("遍历内容：${it.attr("href").substring(1)}, ${it.text()}")
            data.add(History(it.attr("href").substring(1), it.text()))
        }
        return data
    }


    override fun onDetach() {
        super.onDetach()
        this.activity = null
    }


}