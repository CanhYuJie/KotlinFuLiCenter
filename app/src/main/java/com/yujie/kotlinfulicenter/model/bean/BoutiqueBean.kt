package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class BoutiqueBean(val id: Int = 0,
                   val title: String? = null,
                   val description: String? = null,
                   val name: String? = null,
                   val imageurl: String? = null) : Serializable
    /**
     * id : 262
     * title : 不一样的新妆，不一样的美丽
     * description : 快速增长修护预防脱发洗发水让头发健康快速生长更美丽
     * name : 拯救头发，美丽新妆
     * imageurl : cat_image/boutique1.png
     */