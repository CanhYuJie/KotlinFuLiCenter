package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by yujie on 16-10-13.
 */

data class GoodsDetailsBean(val id: Int = 0,
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
                       val addTime: Long = 0,
                       val shareUrl: String? = null,
                       val promote: Boolean = false,
                       val properties: ArrayList<PropertiesBean>? = null) : Serializable

    /**
     * id : 280
     * goodsId : 7677
     * catId : 291
     * goodsName : 双层分格饭盒 绿色
     * goodsEnglishName : Monbento
     * goodsBrief : PP食品级材质，轻巧、易清洗、蠕变性小，不易变形，可置于微波炉加热，可方巾洗碗机清洗。双层色彩可以随意组合，轻巧方便。
     * shopPrice : ￥253
     * currencyPrice : ￥293
     * promotePrice : ￥0
     * rankPrice : ￥293
     * isPromote : false
     * goodsThumb : 201509/thumb_img/7677_thumb_G_1442391216339.png
     * goodsImg : 201509/thumb_img/7677_thumb_G_1442391216339.png
     * addTime : 1442419200000
     * shareUrl : http://m.fulishe.com/item/7677
     * properties : [{"id":9529,"goodsId":0,"colorId":7,"colorName":"白色","colorCode":"#ffffff","colorImg":"","colorUrl":"https://detail.tmall.com/item.htm?spm=a1z10.5-b.w4011-3609973698.66.6PtkVY&id=520971761592&rn=5ddf7aff64dbe1a24da0eaf7409e3389&abbucket=15&skuId=3104519239252","albums":[{"pid":7677,"imgId":28296,"imgUrl":"201509/goods_img/7677_P_1442391216432.png","thumbUrl":"no_picture.gif"},{"pid":7677,"imgId":28297,"imgUrl":"201509/goods_img/7677_P_1442391216215.png","thumbUrl":"no_picture.gif"},{"pid":7677,"imgId":28298,"imgUrl":"201509/goods_img/7677_P_1442391216692.png","thumbUrl":"no_picture.gif"},{"pid":7677,"imgId":28299,"imgUrl":"201509/goods_img/7677_P_1442391216316.png","thumbUrl":"no_picture.gif"}]}]
     * promote : false
     */
    /**
     * id : 9529
     * goodsId : 0
     * colorId : 7
     * colorName : 白色
     * colorCode : #ffffff
     * colorImg :
     * colorUrl : https://detail.tmall.com/item.htm?spm=a1z10.5-b.w4011-3609973698.66.6PtkVY&id=520971761592&rn=5ddf7aff64dbe1a24da0eaf7409e3389&abbucket=15&skuId=3104519239252
     * albums : [{"pid":7677,"imgId":28296,"imgUrl":"201509/goods_img/7677_P_1442391216432.png","thumbUrl":"no_picture.gif"},{"pid":7677,"imgId":28297,"imgUrl":"201509/goods_img/7677_P_1442391216215.png","thumbUrl":"no_picture.gif"},{"pid":7677,"imgId":28298,"imgUrl":"201509/goods_img/7677_P_1442391216692.png","thumbUrl":"no_picture.gif"},{"pid":7677,"imgId":28299,"imgUrl":"201509/goods_img/7677_P_1442391216316.png","thumbUrl":"no_picture.gif"}]
     */