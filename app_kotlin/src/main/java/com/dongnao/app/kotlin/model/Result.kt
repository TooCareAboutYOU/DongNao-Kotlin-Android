package com.dongnao.app.kotlin.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author zhangshuai
 * @date 2019-10-28 10:01
 */

@SuppressLint("ParcelCreator")
@Parcelize
open class Result(val category: List<String>, val error: Boolean, val results: List<DataEntity>) :
    Parcelable