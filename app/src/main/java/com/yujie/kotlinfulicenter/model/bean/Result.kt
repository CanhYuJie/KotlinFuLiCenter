package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-21.
 */
data class Result (val retCode : Int,val retMsg : Boolean,val retData : RetDataBean? = null) : Serializable