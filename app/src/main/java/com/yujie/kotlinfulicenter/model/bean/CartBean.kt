package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class CartBean(val id: Int = 0,
                    val userName: String? = null,
                    val goodsId: Int = 0,
                    val goods: Any? = null,
                    val count: Int = 0,
                    val isIsChecked: Boolean = false,
                    val checked: Boolean = false) : Serializable

    /**
     * id : 35
     * userName : a952702
     * goodsId : 7677
     * goods : null
     * count : 2
     * isChecked : false
     * checked : false
     */
