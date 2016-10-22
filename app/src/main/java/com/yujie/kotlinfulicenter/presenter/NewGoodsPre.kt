package com.yujie.kotlinfulicenter.presenter

import android.support.v4.app.FragmentActivity
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.yujie.kotlinfulicenter.I
import com.yujie.kotlinfulicenter.R
import com.yujie.kotlinfulicenter.model.bean.NewGoodsBean
import com.yujie.kotlinfulicenter.utils.OkHttpUtils
import com.yujie.kotlinfulicenter.utils.OkHttpUtils.OnCompleteListener
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
                  val recycler : RecyclerView
                  ) {


}