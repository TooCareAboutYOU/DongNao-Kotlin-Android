package com.dongnao.app.kotlin.ui.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.DialogFragment

/**
 * @author zhangshuai
 * @date 2019-10-28 18:08
 */
class ProgressFragment : DialogFragment() {
    companion object {
        fun newinstance(): ProgressFragment {
            return ProgressFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return ProgressBar(activity)
    }
}