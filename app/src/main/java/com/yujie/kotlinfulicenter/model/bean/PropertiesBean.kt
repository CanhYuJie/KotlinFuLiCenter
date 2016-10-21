package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by yujie on 16-10-13.
 */

data class PropertiesBean(val id: Int = 0,
                     val goodsId: Int = 0,
                     val colorId: Int = 0,
                     val colorName: String? = null,
                     val colorCode: String? = null,
                     val colorImg: String? = null,
                     val colorUrl: String? = null,
                     val albums: ArrayList<AlbumsBean>? = null) : Serializable

    /**
     * pid : 6936
     * imgId : 26104
     * imgUrl : 201508/goods_img/6936_P_1439535131675.png
     * thumbUrl : no_picture.gif
     */
    /**
     * id : 8514
     * goodsId : 0
     * colorId : 4
     * colorName : 绿色
     * colorCode : #59d85c
     * colorImg : 201309/1380064997570506166.jpg
     * colorUrl : https://cn.shopbop.com/alexa-chung-loretta-romper-ag/vp/v=1/1573999972.htm?fm=search-shopbysize&os=false
     * albums : [{"pid":6936,"imgId":26104,"imgUrl":"201508/goods_img/6936_P_1439535131675.png","thumbUrl":"no_picture.gif"}]
     */
