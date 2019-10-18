package com.dongnao.kotlin.rrd.ui.searchuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dongnao.kotlin.rrd.R
import com.dongnao.kotlin.rrd.model.ItemSearchUserListBean
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

/**
 * @author zhangshuai
 * @date 2019-10-18 15:57
 */

class SearchUserAdapter(val context: Context) : RecyclerView.Adapter<SearchUserAdapter.ItemViewHolder>() {

    val list: ArrayList<ItemSearchUserListBean> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_search_user_list_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Glide.with(context).load(list[position].avatar_url).into(holder.logo)
        holder.tvName.text = list[position].login
        holder.tvScore.text = list[position].score.toString()
        holder.tvUserId.text = list[position].node_id
        holder.tvGoGithub.onClick {
            context.toast("点击了 ${list[position].toString()}")
        }
    }


    fun update(lists: ArrayList<ItemSearchUserListBean>){
        list.clear()
        list.addAll(lists)
        notifyDataSetChanged()
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo: AppCompatImageView = itemView.find(R.id.acImgUserLogo)
        val tvName: AppCompatTextView = itemView.find(R.id.acTvUserName)
        val tvScore: AppCompatTextView = itemView.find(R.id.acTvScore)
        val tvUserId: AppCompatTextView = itemView.find(R.id.acTvUserId)
        val tvGoGithub: AppCompatTextView = itemView.find(R.id.acTvGoGitHubHtml)
    }

}