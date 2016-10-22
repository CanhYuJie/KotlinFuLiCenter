package com.yujie.kotlinfulicenter.model.bean

import java.io.Serializable
import java.util.*

/**
 * Created by yujie on 16-10-22.
 */
data class AlbumsBean(val pid: Int,
                      val imgId: Int,
                      val imgUrl: String?,
                      val thumbUrl: String?) : Serializable

data class BoutiqueBean(val id: Int,
                        val title: String,
                        val description: String,
                        val name: String,
                        val imageurl: String) : Serializable

data class CartBean(val id: Int,
                    val userName: String,
                    val goodsId: Int,
                    val goods: Any?,
                    val count: Int,
                    val isIsChecked: Boolean,
                    val checked: Boolean) : Serializable

data class CategoryChildBean(val id: Int,
                             val parentId: Int,
                             val name: String,
                             val imageUrl: String?) : Serializable

data class CategoryGroupBean(val id: Int,
                             val name: String,
                             val imageUrl: String?) : Serializable

data class CollectBean( val id: Int,
                        val userName: Int,
                        val goodsId: Int,
                        val goodsName: String,
                        val goodsEnglishName: String,
                        val goodsThumb: String,
                        val goodsImg: String?,
                        val addTime: Long) : Serializable

data class ColorBean(val colorId: Int,
                     val colorName: String,
                     val colorCode: String,
                     val colorImg: String,
                     val colorUrl: String) : Serializable

data class GoodsDetailsBean(val id: Int,
                            val goodsId: Int,
                            val catId: Int,
                            val goodsName: String,
                            val goodsEnglishName: String,
                            val goodsBrief: String,
                            val shopPrice: String,
                            val currencyPrice: String,
                            val promotePrice: String,
                            val rankPrice: String,
                            val isIsPromote: Boolean,
                            val goodsThumb: String?,
                            val goodsImg: String?,
                            val addTime: Long,
                            val shareUrl: String,
                            val promote: Boolean,
                            val properties: ArrayList<PropertiesBean>?) : Serializable

data class MessageBean(val isSuccess: Boolean,
                       val msg: String?) : Serializable

data class NewGoodsBean(val id: Int,
                        val goodsId: Int,
                        val catId: Int,
                        val goodsName: String,
                        val goodsEnglishName: String,
                        val goodsBrief: String,
                        val shopPrice: String,
                        val currencyPrice: String,
                        val promotePrice: String,
                        val rankPrice: String,
                        val isIsPromote: Boolean,
                        val goodsThumb: String?,
                        val goodsImg: String?,
                        val colorId: Int?,
                        val colorName: String?,
                        val colorCode: String?,
                        val colorUrl: String?,
                        val addTime: Long,
                        val promote: Boolean) : Serializable

data class PropertiesBean(val id: Int,
                          val goodsId: Int,
                          val colorId: Int,
                          val colorName: String?,
                          val colorCode: String?,
                          val colorImg: String?,
                          val colorUrl: String?,
                          val albums: ArrayList<AlbumsBean>?) : Serializable

data class Result (val retCode : Int,val retMsg : Boolean,val retData : RetDataBean?) : Serializable

data class RetDataBean(val muserName     : String,
                       val muserNick     : String,
                       val mavatarId     : Int,
                       val mavatarPath   : String,
                       val mavatarSuffix : String,
                       val mavatarType   : Int,
                       val mavatarLastUpdateTime : String) : Serializable