package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */
data class AlbumsBean(val pid: Int = 0,
                      val imgId: Int = 0,
                      val imgUrl: String? = null,
                      val thumbUrl: String? = null) : Serializable

    /**
     * pid : 6936
     * imgId : 26104
     * imgUrl : 201508/goods_img/6936_P_1439535131675.png
     * thumbUrl : no_picture.gif
     */