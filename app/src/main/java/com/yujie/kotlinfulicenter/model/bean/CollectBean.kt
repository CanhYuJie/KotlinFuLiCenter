package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable

/**
 * Created by yujie on 16-10-13.
 */

data class CollectBean( val id: Int = 0,
                   val userName: Int = 0,
                   val goodsId: Int = 0,
                   val goodsName: String? = null,
                   val goodsEnglishName: String? = null,
                   val goodsThumb: String? = null,
                   val goodsImg: String? = null,
                   val addTime: Long = 0) : Serializable

    /**
     * id : 7672
     * userName : 7672
     * goodsId : 7672
     * goodsName : 趣味煮蛋模具
     * goodsEnglishName : Kotobuki
     * goodsThumb : http://121.197.1.20/images/201507/thumb_img/6372_thumb_G_1437108490316.jpg
     * goodsImg : http://121.197.1.20/images/201507/1437108490034171398.jpg
     * addTime : 1442419200000
     */