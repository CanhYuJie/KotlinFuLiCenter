package com.yujie.kotlinfulicenter.adapter

import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.yujie.kotlinfulicenter.I
import com.yujie.kotlinfulicenter.R
import com.yujie.kotlinfulicenter.model.bean.NewGoodsBean
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import java.util.*

/**
 * Created by yujie on 16-10-22.
 */

var adapter : CommonAdapter<NewGoodsBean>? = null
fun setNewGoodsAdapter(activity: FragmentActivity,recycler: RecyclerView,manager : RecyclerView.LayoutManager,data : ArrayList<NewGoodsBean>) : RecyclerView.Adapter<ViewHolder>{
    recycler.layoutManager = manager
    adapter = object : CommonAdapter<NewGoodsBean>(activity, R.layout.new_goods_item_layout,data){
        override fun convert(holder: ViewHolder?, t: NewGoodsBean?, position: Int) {
            Picasso.with(activity).
                    load(I.DOWNLOAD_IMG_URL + t?.goodsThumb)
                    .placeholder(R.drawable.nopic)
                    .error(R.drawable.nopic)
                    .into(holder?.getView<ImageView>(R.id.adapter_item_new_goods_img))
            holder?.setText(R.id.adapter_item_new_goods_name,t?.goodsName)
            holder?.setText(R.id.adapter_item_new_goods_price,t?.currencyPrice)
            holder?.setOnClickListener(R.id.adapter_item_new_goods_root) {

            }
        }

    }
    return adapter!!
}

