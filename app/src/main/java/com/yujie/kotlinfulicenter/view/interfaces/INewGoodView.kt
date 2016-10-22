package com.yujie.kotlinfulicenter.view.interfaces

import com.yujie.kotlinfulicenter.model.bean.CategoryChildBean

/**
 * Created by yujie on 16-10-21.
 */
interface INewGoodView {
    fun getDetail(goodsId : Int?)
    fun getDetailFailed(msg : String?)
    fun replaceData(child : CategoryChildBean)
}