package com.yujie.kotlinfulicenter.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup

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
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_new_good, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        pre = NewGoodsPre(this,activity,fragment_RecyclerView_new_goods)
    }
    private fun initToolbar() {
        ToolbarUtils.setToolbar(fragment_Toolbar_titlebar, "新品", R.mipmap.menu_item_new_good_normal)
        fragment_Toolbar_titlebar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.time_sort      -> {}
                    R.id.money_sort     -> {}
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