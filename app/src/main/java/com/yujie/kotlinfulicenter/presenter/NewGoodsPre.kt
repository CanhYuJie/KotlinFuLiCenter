package com.yujie.kotlinfulicenter.presenter

import android.support.v4.app.FragmentActivity
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.yujie.kotlinfulicenter.I
import com.yujie.kotlinfulicenter.R
import com.yujie.kotlinfulicenter.adapter.*
import com.yujie.kotlinfulicenter.model.bean.NewGoodsBean
import com.yujie.kotlinfulicenter.utils.OkHttpUtils
import com.yujie.kotlinfulicenter.utils.OkHttpUtils.OnCompleteListener
import com.yujie.kotlinfulicenter.utils.array2List
import com.yujie.kotlinfulicenter.utils.sortData
import com.yujie.kotlinfulicenter.view.interfaces.INewGoodView
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper
import java.util.*

/**
 * Created by yujie on 16-10-21.
 */
class NewGoodsPre(val view : INewGoodView,
                  val activity : FragmentActivity,
                  recycler : RecyclerView
                  ) {
    val TAG : String = NewGoodsPre::class.java.simpleName
    var data : ArrayList<NewGoodsBean> = ArrayList()
    var refresh : SwipeRefreshLayout? = null
    val manager = GridLayoutManager(activity,2)
    var loadMore : LoadMoreWrapper<String>
    val footer : TextView = TextView(activity)
    var def_id = 1
    var hasMore = true
    var cat_id = 0
    get
    set(value) {
        cat_id = value
    }
    init {
        setNewGoodsAdapter(activity, recycler, manager, data)
        loadMore = LoadMoreWrapper(adapter)
        footer.text = "正在加载更多数据"
        loadMore.setLoadMoreView(footer)
        loadMore.setOnLoadMoreListener {
            when{
                data?.size === 0        -> {
                    def_id = 1
                    getNewGoods(def_id,I.METHOD_INIT)
                }
                else                    -> {
                    if (hasMore){
                        def_id++
                        getNewGoods(def_id, I.METHOD_LOADMORE)
                    }
                }
            }
        }
        recycler.adapter = loadMore
    }
    fun getNewGoods(id: Int, method: Int) {
        val util = OkHttpUtils<Array<NewGoodsBean>>(activity)
        util.setRequestUrl(I.REQUEST_FIND_NEW_BOUTIQUE_GOODS)
                .addParam(I.NewAndBoutiqueGoods.CAT_ID,cat_id.toString())
                .addParam(I.PAGE_ID,id.toString())
                .addParam(I.PAGE_SIZE,I.PAGE_SIZE_DEFAULT.toString())
                .targetClass(Array<NewGoodsBean>::class.java)
                .execute(object : OnCompleteListener<Array<NewGoodsBean>>{
                    override fun onError(error: String?) {
                        view.getDetailFailed(error)
                    }

                    override fun onSuccess(result: Array<NewGoodsBean>) {
                        if (result != null && result.size>0) {
                            val list = array2List(result)
                            when(method){
                                I.METHOD_INIT         ->  {
                                    data.clear()
                                    data.addAll(list!!)
                                    sortList(I.SORT_BY_PRICE_ASC)
                                    loadMore.notifyDataSetChanged()
                                }
                                I.METHOD_LOADMORE     ->  {
                                    data.addAll(list!!)
                                    sortList(I.SORT_BY_PRICE_ASC)
                                    loadMore.notifyDataSetChanged()
                                }
                                I.METHOD_REFRESH      ->  {
                                    data.clear()
                                    data.addAll(list!!)
                                    refresh?.isRefreshing = false
                                    hasMore = true
                                    sortList(I.SORT_BY_PRICE_ASC)
                                    loadMore.notifyDataSetChanged()
                                }
                            }
                        }else{
                            footer.text = "已经没有更多了"
                            def_id = 1
                            hasMore = false
                            loadMore?.notifyDataSetChanged()
                        }
                    }
                })

    }

    fun refresh(refresh: SwipeRefreshLayout): Unit {
        this.refresh = refresh
        data.clear()
        def_id = 1
        footer.text = "正在加载更多"
        getNewGoods(def_id,I.METHOD_REFRESH)
    }

    fun sortList(sort_id: Int){
        if (data != null) {
            sortData(sort_id,data)
            loadMore.notifyDataSetChanged()
        }
    }
}


