package com.dongnao.app.kotlin.ui.adapters

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dongnao.app.kotlin.R
import com.dongnao.app.kotlin.model.History

/**
 * @author zhangshuai
 * @date 2019-11-26 15:43
 */

class HistoryAdapter(layoutId: Int, list: MutableList<History>?) :
    BaseQuickAdapter<History, BaseViewHolder>(layoutId, list) {

    override fun convert(helper: BaseViewHolder?, item: History?) {
        println("显示：${item?.content} , ${item?.date}")
        helper?.setText(R.id.acTvContent, item?.content)?.setText(R.id.acTvDate, item?.date)
    }

}