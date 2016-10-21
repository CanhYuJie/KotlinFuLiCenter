package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class ColorBean(val colorId: Int = 0,
                val colorName: String? = null,
                val colorCode: String? = null,
                val colorImg: String? = null,
                val colorUrl: String? = null) : Serializable

    /**
     * colorId : 4
     * colorName : 绿色
     * colorCode : #59d85c
     * colorImg : 201309/1380064997570506166.jpg
     * colorUrl : https://cn.shopbop.com/alexa-chung-loretta-romper-ag/vp/v=1/1573999972.htm?fm=search-shopbysize&os=false
     */