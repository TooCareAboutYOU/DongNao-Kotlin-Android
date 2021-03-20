package com.dongnao.app.kotlin.model

/**
 * @author zhangshuai
 * @date 2019-10-28 10:26
 */

data class History(val date: String, val content: String)

data class PublishedDate(val error: Boolean, val results: List<String>)