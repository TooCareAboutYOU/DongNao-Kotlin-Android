package com.zs.book

/**
 * @author zhangshuai
 * @date 2019-12-04 11:53
 */

class Person(val name: String) {
    companion object Loader : JSONFactory<Person?> {
        override fun fromJSON(jsonText: String): Person? {
            return null
        }
    }
}