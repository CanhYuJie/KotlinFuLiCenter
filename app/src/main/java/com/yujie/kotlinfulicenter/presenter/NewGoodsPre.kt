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
    var def_id = 1
    val manager : GridLayoutManager = GridLayoutManager(activity,2)
    var loadMore : LoadMoreWrapper<String>? = null
    var adapter : CommonAdapter<NewGoodsBean>? = null
    var data : ArrayList<NewGoodsBean>? = ArrayList()
    val footer : TextView = TextView(activity)
    var refresh : SwipeRefreshLayout? = null
    var cat_id : Int = 0
        get
    set(value) {
        this.cat_id = value
    }

    companion object{
        val METHOD_INIT = 101
        val METHOD_REFRESH = 102
        val METHOD_LOADMORE = 103
    }

    init {
        recycler.layoutManager = manager
        adapter = object : CommonAdapter<NewGoodsBean>(activity,R.layout.new_goods_item_layout,data){
            override fun convert(holder: ViewHolder?, t: NewGoodsBean?, position: Int) {
                Picasso.with(activity).
                        load(I.DOWNLOAD_IMG_URL + t?.goodsThumb)
                        .placeholder(R.drawable.nopic)
                        .error(R.drawable.nopic)
                        .into(holder?.getView<ImageView>(R.id.adapter_item_new_goods_img))
                holder?.setText(R.id.adapter_item_new_goods_name,t?.goodsName)
                holder?.setText(R.id.adapter_item_new_goods_price,t?.currencyPrice)
                holder?.setOnClickListener(R.id.adapter_item_new_goods_root) {
                    view.getDetail(t?.goodsId)
                }
            }

        }
        loadMore = LoadMoreWrapper(adapter)
        footer.text = "正在加载更多数据"
        loadMore?.setLoadMoreView(footer)
        loadMore?.setOnLoadMoreListener {
            when{
                data?.size === 0        -> {
                    def_id = 1
                    getNewGoods(def_id,METHOD_INIT)
                }
                else                    -> {
                    def_id++
                    getNewGoods(def_id, METHOD_LOADMORE)
                }
            }
        }
        recycler.adapter = loadMore
    }

    fun getNewGoods(def_id: Int, method: Int) {
        val util = OkHttpUtils<Array<NewGoodsBean>>(activity)
        util.setRequestUrl(I.REQUEST_FIND_NEW_BOUTIQUE_GOODS)
                .addParam(I.NewAndBoutiqueGoods.CAT_ID,cat_id.toString())
                .addParam(I.PAGE_ID,def_id.toString())
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
                                METHOD_INIT         ->  {
                                    data?.clear()
                                    data?.addAll(list!!)
                                    sortList(I.SORT_BY_PRICE_ASC)
                                    loadMore?.notifyDataSetChanged()
                                }
                                METHOD_LOADMORE     ->  {
                                    data?.addAll(list!!)
                                    sortList(I.SORT_BY_PRICE_ASC)
                                    loadMore?.notifyDataSetChanged()
                                }
                                METHOD_REFRESH      ->  {
                                    data?.clear()
                                    data?.addAll(list!!)
                                    refresh?.isRefreshing = false
                                    sortList(I.SORT_BY_PRICE_ASC)
                                    loadMore?.notifyDataSetChanged()
                                }
                            }
                        }else{
                            footer.text = "已经没有更多了"
                            loadMore?.notifyDataSetChanged()
                        }
                    }
                })

    }

    fun refresh(refresh: SwipeRefreshLayout): Unit {
        this.refresh = refresh
        data?.clear()
        def_id = 1
        getNewGoods(def_id,METHOD_REFRESH)
    }

    fun sortList(sort_id: Int){
        if (data != null) {
            sortData(sort_id,data!!)
            loadMore?.notifyDataSetChanged()
        }
    }
}

private fun <T> LoadMoreWrapper<T>.setLoadMoreView(footer: TextView) {
    setLoadMoreView(footer)
}

