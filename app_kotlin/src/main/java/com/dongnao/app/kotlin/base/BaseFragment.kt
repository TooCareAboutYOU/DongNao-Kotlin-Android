package com.dongnao.app.kotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


/**
 * @author zhangshuai
 * @date 2019-10-28 11:43
 */

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    lateinit var rootView: View

    lateinit var mDataBinding: ViewDataBinding

    abstract val layoutResId: Int

    private var attachToParent: Boolean = false

    fun setAttachToParent(status: Boolean) {
        attachToParent = status
    }

    abstract fun init()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, layoutResId, container, attachToParent)
        rootView = mDataBinding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
}