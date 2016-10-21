package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-21.
 */
data class RetDataBean(val muserName     : String,
                       val muserNick     : String,
                       val mavatarId     : Int,
                       val mavatarPath   : String,
                       val mavatarSuffix : String,
                       val mavatarType   : Int,
                       val mavatarLastUpdateTime : String) : Serializable