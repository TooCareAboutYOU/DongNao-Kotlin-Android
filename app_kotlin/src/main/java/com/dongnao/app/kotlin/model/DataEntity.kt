package com.dongnao.app.kotlin.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class DataEntity(
    val _id: String? = "",
    val createdAt: String? = "",
    val desc: String? = "",
    val images: List<String?>? = listOf(),
    val publishedAt: String? = "",
    val source: String? = "",
    val type: String? = "",
    val url: String? = "",
    val used: Boolean? = false,
    val who: String? = ""
) : Parcelable