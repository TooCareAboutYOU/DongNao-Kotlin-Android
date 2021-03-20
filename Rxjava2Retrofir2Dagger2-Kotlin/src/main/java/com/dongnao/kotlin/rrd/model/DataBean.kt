package com.dongnao.kotlin.rrd.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable




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
 * java class转换kotlin 而成
 * --------------------------- 用户列表 ----------------------------------

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
    val following_url: String? = "",
    val gists_url: String? = "",
    val starred_url: String? = "",
    val subscriptions_url: String? = "",
    val organizations_url: String? = "",
    val repos_url: String? = "",
    val events_url: String? = "",
    val received_events_url: String? = "",
    val type: String? = "",
    val site_admin: Boolean? = false,
    val name: String? = "",
    val company: Any? = Any(),
    val blog: String? = "",
    val location: String? = "",
    val email: Any? = Any(),
    val hireable: Any? = Any(),
    val bio: Any? = Any(),
    val public_repos: Int? = 0,
    val public_gists: Int? = 0,
    val followers: Int? = 0,
    val following: Int? = 0,
    val created_at: String? = "",
    val updated_at: String? = "",
    val score: Double? = 0.0
) {
    override fun toString(): String {
        return "ItemSearchUserListBean(login=$login, id=$id, node_id=$node_id, avatar_url=$avatar_url, gravatar_id=$gravatar_id, url=$url, html_url=$html_url, followers_url=$followers_url, following_url=$following_url, gists_url=$gists_url, starred_url=$starred_url, subscriptions_url=$subscriptions_url, organizations_url=$organizations_url, repos_url=$repos_url, events_url=$events_url, received_events_url=$received_events_url, type=$type, site_admin=$site_admin, name=$name, company=$company, blog=$blog, location=$location, email=$email, hireable=$hireable, bio=$bio, public_repos=$public_repos, public_gists=$public_gists, followers=$followers, following=$following, created_at=$created_at, updated_at=$updated_at, score=$score)"
    }
}