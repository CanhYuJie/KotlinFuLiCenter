package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class NewGoodsBean(val id: Int = 0,
                   val goodsId: Int = 0,
                   val catId: Int = 0,
                   val goodsName: String? = null,
                   val goodsEnglishName: String? = null,
                   val goodsBrief: String? = null,
                   val shopPrice: String? = null,
                   val currencyPrice: String? = null,
                   val promotePrice: String? = null,
                   val rankPrice: String? = null,
                   val isIsPromote: Boolean = false,
                   val goodsThumb: String? = null,
                   val goodsImg: String? = null,
                   val colorId: Int = 0,
                   val colorName: String? = null,
                   val colorCode: String? = null,
                   val colorUrl: String? = null,
                   val addTime: Long = 0,
                   val promote: Boolean = false) : Serializable


    /**
     * id : 1
     * goodsId : 7672
     * catId : 0
     * goodsName : 趣味煮蛋模具
     * goodsEnglishName : Kotobuki
     * goodsBrief : 将煮好的鸡蛋放到模具中，扣好卡扣，把蛋模放冰水，耐心等上10分钟，就可以变化成各种各样的形状，宝宝看了说不定胃口大开！
     * shopPrice : ￥110
     * currencyPrice : ￥140
     * promotePrice : ￥0
     * rankPrice : ￥0
     * isPromote : false
     * goodsThumb : 201509/thumb_img/7672_thumb_G_1442389445719.jpg
     * goodsImg : 201509/goods_img/7672_P_1442389445199.jpg
     * colorId : 4
     * colorName : 绿色
     * colorCode : #59d85c
     * colorUrl : 1
     * addTime : 1442389445
     * promote : false
     */


