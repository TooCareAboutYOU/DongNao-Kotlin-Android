package com.dongnao.kotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.dongnao.kotlin.app.KotlinApplication
import com.dongnao.kotlin.model.WeatherBean
import org.jetbrains.anko.db.*

/**
 * Anko创建本地数据库
 */
val Context.database: MyDatabaseOpenHelper get() = MyDatabaseOpenHelper.getInstance()

class MyDatabaseOpenHelper(
    context: Context = KotlinApplication.getApplication(),
    name: String? = "MyDb",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1
) : ManagedSQLiteOpenHelper(context, name, factory, version) {

    val tName: String = WeatherBean.TABLE_NAME

    //单例模式:创建伴生对象
    companion object {
        @Volatile
        private var instance: MyDatabaseOpenHelper? = null

        /**
         * 方式一
         */
//        @Synchronized
//        fun getInstance(ctx: Context)  : MyDatabaseOpenHelper = instance ?: MyDatabaseOpenHelper(ctx.applicationContext)

        fun getInstance(): MyDatabaseOpenHelper {
            if (null == instance) {
                synchronized(MyDatabaseOpenHelper::class) {
                    if (null == instance) {
                        instance = MyDatabaseOpenHelper()
                    }
                }
            }
            return instance!!
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(tName, true)
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            tName,
            true,
            WeatherBean.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            WeatherBean.DATE to TEXT,
            WeatherBean.HIGH to TEXT,
            WeatherBean.LOW to TEXT,
            WeatherBean.YMD to TEXT,
            WeatherBean.WEEK to TEXT,
            WeatherBean.SUNRISE to TEXT,
            WeatherBean.SUNSET to TEXT,
            WeatherBean.FX to TEXT,
            WeatherBean.FL to TEXT,
            WeatherBean.TYPE to TEXT,
            WeatherBean.NOTICE to TEXT
        )
    }

    /**
     * 保存
     */
    fun saveAll(data: List<WeatherBean>) = use {
        transaction {
            data.forEach {
                val status: Long = insert(
                    tName,
                    WeatherBean.DATE to it.date,
                    WeatherBean.HIGH to it.high,
                    WeatherBean.LOW to it.low,
                    WeatherBean.YMD to it.ymd,
                    WeatherBean.WEEK to it.week,
                    WeatherBean.SUNRISE to it.sunrise,
                    WeatherBean.SUNSET to it.sunset,
                    WeatherBean.FX to it.fx,
                    WeatherBean.FL to it.fl,
                    WeatherBean.TYPE to it.type,
                    WeatherBean.NOTICE to it.notice
                )
                println("添加数据：${status}")
            }
        }
    }


    /**
     * 查询全部
     */
    fun queryAll(): List<WeatherBean> = use {
        select(tName).exec {
            /**
             * 如果是使用java编写的实体类
             * 查询使用parserXX方法需要存在查询字段的相应构造方法
             */
            parseList(classParser<WeatherBean>())
        }
    }

    /**
     * 条件精确查询
     */
    fun queryByConditions(dates: String): List<String> = use {
        select(tName, WeatherBean.WEEK).whereArgs("${WeatherBean.DATE}={sDate}", "sDate" to dates)
            .exec {
                parseList(StringParser)
            }
    }

    /**
     * 更新
     */
    fun updateById(index: Int, type: String): Int = use {
        update(tName, WeatherBean.TYPE to type).whereArgs("${WeatherBean.ID}={id}", "id" to index)
            .exec()
    }

    fun delete(condition: String): Int {
        var count = 0
        use {
            count = delete(tName, condition, null)
        }
        return count
    }

    /**
     * 删除
     */
    fun deleteById(index: Int): Int = use {
        delete(tName, "${WeatherBean.ID}={i}", "i" to index)
    }

    /**
     * 清空
     */
    fun clear(): Int = use {
        delete("1=1")
    }
}


//自定义
//class MyParser : RowParser<WeatherBean> {
//    override fun parseRow(columns: Array<Any?>): WeatherBean {
//        val bean = WeatherBean()
//        bean.id = columns[0] as Int
//        return bean
//    }
//}



