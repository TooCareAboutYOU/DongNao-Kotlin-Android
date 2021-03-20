package com.dongnao.app.kotlin.utils

import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dongnao.app.kotlin.ui.fragment.ProgressFragment

/**
 * @author zhangshuai
 * @date 2019-11-26 15:16
 */

fun AppCompatActivity.toast(msg: String) {
    val toast: Toast = Toast(applicationContext)
    toast.setText(msg)
    toast.duration = Toast.LENGTH_SHORT
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.show()
//    Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showProgress() {
    val dialog = ProgressFragment.newinstance()
    dialog.show(this.supportFragmentManager, ProgressFragment::class.java.simpleName)
}

fun AppCompatActivity.dismissProgress() {
    (this.supportFragmentManager.findFragmentByTag(ProgressFragment::class.java.simpleName) as ProgressFragment).dismiss()
}




