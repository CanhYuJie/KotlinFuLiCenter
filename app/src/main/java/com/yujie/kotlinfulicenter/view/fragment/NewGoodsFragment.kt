package com.yujie.kotlinfulicenter.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.yujie.kotlinfulicenter.I

import com.yujie.kotlinfulicenter.R
import com.yujie.kotlinfulicenter.model.bean.CategoryChildBean
import com.yujie.kotlinfulicenter.presenter.NewGoodsPre
import com.yujie.kotlinfulicenter.utils.ToolbarUtils
import com.yujie.kotlinfulicenter.view.interfaces.INewGoodView
import kotlinx.android.synthetic.main.fragment_new_good.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class NewGoodsFragment : Fragment(),INewGoodView {
    val TAG : String = NewGoodsFragment::class.java.simpleName
    var pre : NewGoodsPre? = null
    var moneyFlag = false
    var timeFlag = false
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_new_good, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initRefresh()
        pre = NewGoodsPre(this,activity,fragment_RecyclerView_new_goods)
        pre?.getNewGoods(I.PAGE_ID_DEFAULT,NewGoodsPre.METHOD_INIT)
    }

    private fun initRefresh() {
        fragment_SwipeRefreshLayout_refresh.setOnRefreshListener {
            pre?.refresh(fragment_SwipeRefreshLayout_refresh)
        }
    }

    private fun initToolbar() {
        ToolbarUtils.setToolbar(fragment_Toolbar_titlebar, "新品", R.mipmap.menu_item_new_good_normal)
        fragment_Toolbar_titlebar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.time_sort      -> {
                        if (moneyFlag){
                            pre?.sortList(I.SORT_BY_PRICE_DESC)
                            moneyFlag = false
                        }else{
                            pre?.sortList(I.SORT_BY_PRICE_ASC)
                            moneyFlag = true
                        }
                    }
                    R.id.money_sort     -> {
                        if (timeFlag){
                            pre?.sortList(I.SORT_BY_ADDTIME_DESC)
                            timeFlag = false
                        }else{
                            pre?.sortList(I.SORT_BY_ADDTIME_ASC)
                            timeFlag = true
                        }
                    }
                }
                return false
            }

        })
    }


    override fun getDetail(goodsId: Int?) {

    }

    override fun getDetailFailed(msg: String?) {

    }

    override fun replaceData(child: CategoryChildBean) {

    }

}