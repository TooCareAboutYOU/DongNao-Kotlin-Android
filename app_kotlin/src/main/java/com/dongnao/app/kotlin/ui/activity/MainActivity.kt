package com.dongnao.app.kotlin.ui.activity

import androidx.fragment.app.Fragment
import com.dongnao.app.kotlin.R
import com.dongnao.app.kotlin.base.BaseActivity
import com.dongnao.app.kotlin.databinding.ActivityMainBinding
import com.dongnao.app.kotlin.ui.fragment.HistoryFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResId: Int get() = R.layout.activity_main

    override fun init() {
        changeTab(0)
        navigationView.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.action_recommend -> {
                    changeTab(0)
                }
                R.id.action_girl -> {
                    changeTab(1)
                }
                R.id.action_history -> {
                    changeTab(2)
                }
            }
            true
        }
    }

    var lastIndex: Int = -1
    var lastFragment: Fragment? = null
    var historyFragment: HistoryFragment? = null

    fun changeTab(position: Int) {
        if (lastIndex == position) {
            return
        }
        lastIndex = position
        val fragmentManage = supportFragmentManager
        val fragmentTransition = fragmentManage.beginTransaction()

        if (lastFragment != null) {
            fragmentTransition.hide(lastFragment!!)
        }
        when (position) {
            0 -> {
            }
            1 -> {
            }
            2 -> {
                historyFragment =
                    fragmentManage.findFragmentByTag(HistoryFragment::class.java.simpleName) as HistoryFragment?
                if (historyFragment == null) {
                    historyFragment = HistoryFragment.newInstance()
                    fragmentTransition.add(
                        R.id.flViewContainer,
                        historyFragment!!,
                        HistoryFragment::class.java.simpleName
                    )
                    println("创建 HistoryFragment")
                } else {
                    println("显示 HistoryFragment")
                    fragmentTransition.show(historyFragment!!)
                }
                println("加载 HistoryFragment")

                lastFragment = historyFragment
            }
        }
        fragmentTransition.commit()
    }

}
