package com.yujie.kotlinfulicenter.utils

import android.content.Context
import android.widget.EditText
import com.yujie.kotlinfulicenter.I
import com.yujie.kotlinfulicenter.model.bean.NewGoodsBean
import java.util.*

/**
 * Created by yujie on 16-10-21.
 */
    /*
        case array to list
     */
    fun <T>array2List(array: Array<T>): ArrayList<T>?{
        var list : ArrayList<T> = ArrayList()
        if (array.size != 0) {
            for (i in 0..array.size-1){
                list.add(array[i])
            }
            return list
        }
        return null
    }
    /*
    case px to dp
     */
    fun px2dp(context: Context, px: Int): Int? {
        val density = context.resources.displayMetrics.density.toInt()
        return px/density
    }
    /*
    if the widget's text is empty,return false else true
     */
    fun ifEmpty(text: String, widget: EditText): Boolean {
        if (text.isEmpty()){
            widget.error = "不能为空"
            widget.requestFocus()
            return false
        }
        return true
    }

    fun sortData(type: Int, list: ArrayList<NewGoodsBean>): ArrayList<NewGoodsBean> {
        when(type){
            I.SORT_BY_ADDTIME_ASC   ->{
                Collections.sort(list,object : Comparator<NewGoodsBean>{
                    override fun compare(lhs: NewGoodsBean, rhs: NewGoodsBean): Int {
                        val lhstime : Long = lhs.addTime
                        val rhstime : Long = rhs.addTime
                        if (lhstime > rhstime){
                            return 1
                        }else {
                            return -1
                        }
                    }
                })
            }
            I.SORT_BY_ADDTIME_DESC  ->{
                Collections.sort(list,object : Comparator<NewGoodsBean>{
                    override fun compare(lhs: NewGoodsBean, rhs: NewGoodsBean): Int {
                        val lhstime : Long = lhs.addTime
                        val rhstime : Long = rhs.addTime
                        if (lhstime < rhstime){
                            return 1
                        }else {
                            return -1
                        }
                    }
                })
            }
            I.SORT_BY_PRICE_ASC     ->{
                Collections.sort(list,object : Comparator<NewGoodsBean>{
                    override fun compare(lhs: NewGoodsBean, rhs: NewGoodsBean): Int {
                        val lhscurrencyPrice : String = lhs.currencyPrice
                        val rhscurrencyPrice : String = rhs.currencyPrice
                        val lhsPrice : Long = lhscurrencyPrice.substring(1, lhscurrencyPrice.length).toLong()
                        val rhsPrice : Long = rhscurrencyPrice.substring(1, rhscurrencyPrice.length).toLong()
                        if (lhsPrice > rhsPrice){
                            return 1
                        }else {
                            return -1
                        }
                    }
                })
            }
            I.SORT_BY_PRICE_DESC    ->{
                Collections.sort(list,object : Comparator<NewGoodsBean>{
                    override fun compare(lhs: NewGoodsBean, rhs: NewGoodsBean): Int {
                        val lhscurrencyPrice : String = lhs.currencyPrice
                        val rhscurrencyPrice : String = rhs.currencyPrice
                        val lhsPrice : Long = lhscurrencyPrice.substring(1, lhscurrencyPrice.length).toLong()
                        val rhsPrice : Long = rhscurrencyPrice.substring(1, rhscurrencyPrice.length).toLong()
                        if (lhsPrice < rhsPrice){
                            return 1
                        }else {
                            return -1
                        }
                    }
                })
            }
            else ->{}
        }
        return list
    }