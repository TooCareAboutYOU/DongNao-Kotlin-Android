package com.dongnao.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dongnao.kotlin.model.WeatherBean
import com.google.gson.Gson
import java.io.InputStreamReader

class DataBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)

        val reader = InputStreamReader(assets.open("data_db.txt"))
        val list: List<String> = reader.readLines()
        reader.close()

        val dbList = list.map {
            Gson().fromJson(it, WeatherBean::class.java)
        }
        println("-------------------------------------查询全部")
        database.saveAll(dbList)
        database.queryAll().forEach(::println)

        println("-------------------------------------精确查询")
        println("精确打印： ${database.queryByConditions("15")}")

        println("-------------------------------------删除")
        println("${database.deleteById(1)}")
        database.queryAll().forEach(::println)


        println("-------------------------------------更新")
        database.updateById(4,"暴雨")
        database.queryAll().forEach(::println)


        println("-------------------------------------清空")
        val count=database.clear()
        println("清空：${count} 条数据")

    }
}
