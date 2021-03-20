package com.zs.book

/**
 * @author zhangshuai
 * @date 2019-12-04 11:52
 */

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}