package com.dongnao.kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginRight
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dongnao.kotlin.model.DataBean
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.recyclerview.v7.recyclerView
import java.io.InputStream

class AnkoLayoutActivity : AppCompatActivity() {

    val list = ArrayList<DataBean.TrailersBean>()
    lateinit var myAdapter: MyAdapter


    //泛型方法
    inline fun <reified T> getType() = object : TypeToken<T>() {}.type

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myAdapter = MyAdapter(this@AnkoLayoutActivity, list)
        verticalLayout {
            recyclerView {
                layoutManager = LinearLayoutManager(this@AnkoLayoutActivity)
                adapter = this@AnkoLayoutActivity.myAdapter
            }
        }
        loadData(false)

    }

    private fun loadData(boolean: Boolean) {
        if (boolean) {
            GlobalScope.launch {
                var data = runBlocking {
                    println("当前线程1：${Thread.currentThread().name}")
                    val input: InputStream = assets.open("data.json")
                    val readBytes: ByteArray = input.readBytes()
                    input.close()
                    Gson().fromJson<DataBean>(
                        String(readBytes),
                        getType<DataBean>()
                    )
                }
                list.clear()
                println("打印：${data.trailers}")
                list.addAll(data.trailers)
                runOnUiThread {
                    myAdapter.notifyDataSetChanged()
                }
            }.start()
        } else {
            doAsync {
                var data: DataBean = runBlocking {
                    println("当前线程1：${Thread.currentThread().name}")
                    val input: InputStream = assets.open("data.json")
                    val readBytes: ByteArray = input.readBytes()
                    input.close()
                    Gson().fromJson<DataBean>(
                        String(readBytes),
                        getType<DataBean>()
                    )
                }
                list.clear()
                println("打印：${data.trailers}")
                list.addAll(data.trailers)
                runOnUiThread {
                    myAdapter.notifyDataSetChanged()
                }
            }
        }
    }

}

class MyAdapter(val ctx: Context, val list: ArrayList<DataBean.TrailersBean>) :
    RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val holder = ItemViewHolder(ItemViewUI().createView(AnkoContext.createReusable(ctx, this)))
        return holder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Glide.with(ctx).load(list[position].coverImg).placeholder(R.drawable.ic_launcher_background)
            .into(holder.iv)
        holder.tvTitle.text = list[position].movieName
        holder.tvHint.text = list[position].videoTitle
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView = itemView.find(R.id.img_logo)
        val tvTitle: TextView = itemView.find(R.id.tv_title)
        val tvHint: TextView = itemView.find(R.id.tv_hint)
    }
}

class ItemViewUI : AnkoComponent<MyAdapter> {
    override fun createView(ui: AnkoContext<MyAdapter>): View = with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_HORIZONTAL
            padding = dip(5)
            imageView {
                id = R.id.img_logo
                scaleType = ImageView.ScaleType.FIT_XY
            }.lparams(width = dip(48), height = dip(48)) {
                rightMargin = dip(5)
            }
            verticalLayout {
                textView {
                    id = R.id.tv_title
                    textSize = 14f
                }
                textView {
                    id = R.id.tv_hint
                    textSize = 12f
                }
            }
        }
    }
}

