package com.zs.book

/**
 * @author zhangshuai
 * @date 2019-12-04 11:43
 */
fun getFaceBookName(accountId: String) = accountId + System.currentTimeMillis()

class User private constructor(val nickName: String) {
    companion object {
        fun newSubscribingUser(email: String) = User(email.substringBefore('@'))
        fun newFaceBookUser(accountId: String) = User(getFaceBookName(accountId))
    }

}