package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class MessageBean(val isSuccess: Boolean = false,
                  val msg: String? = null) : Serializable
    /**
     * success : true
     * msg : 收藏成功
     */