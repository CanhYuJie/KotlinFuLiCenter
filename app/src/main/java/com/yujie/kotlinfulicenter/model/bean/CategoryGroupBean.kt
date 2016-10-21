package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class CategoryGroupBean(val id: Int = 0,
                        val name: String? = null,
                        val imageUrl: String? = null) : Serializable

    /**
     * id : 344
     * name : 最IN
     * imageUrl : muying/2.jpg
     */