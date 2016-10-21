package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class CategoryChildBean(val id: Int = 0,
                        val parentId: Int = 0,
                        val name: String? = null,
                        val imageUrl: String? = null) : Serializable

    /**
     * id : 345
     * parentId : 344
     * name : 热门
     * imageUrl : cat_image/256_1.png
     */