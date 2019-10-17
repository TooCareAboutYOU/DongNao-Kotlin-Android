package com.dongnao.kotlin.rrd.model

import com.google.gson.annotations.SerializedName


/**
 *retrofit
 */
const val baseUrl: String = "https://api.github.com/"
/**
 * json解析基类
 */
data class BaseBean<T>(
    @SerializedName("total_count")
    val totalCount: Int? = 0,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = false,
    @SerializedName("items")
    val items: T? = null
)
/**
 * --------------------------- 用户列表 ----------------------------------
 */
data class ItemSearchUserListBean(
    val login: String? = "",
    val id: Int? = 0,
    val node_id: String? = "",
    val avatar_url: String? = "",
    val gravatar_id: String? = "",
    val url: String? = "",
    val html_url: String? = "",
    val followers_url: String? = "",
    val subscriptions_url: String? = "",
    val organizations_url: String? = "",
    val repos_url: String? = "",
    val received_events_url: String? = "",
    val type: String? = "",
    val score: Double? = 0.0
)