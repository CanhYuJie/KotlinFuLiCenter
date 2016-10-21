package com.yujie.kotlinfulicenter.view.activity

import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.widget.RadioButton
import com.yujie.kotlinfulicenter.FuLiCenterApp
import com.yujie.kotlinfulicenter.R
import com.yujie.kotlinfulicenter.presenter.MainPre
import com.yujie.kotlinfulicenter.view.fragment.*
import com.yujie.kotlinfulicenter.view.interfaces.IMainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IMainView {
    val TAG : String  = MainActivity::class.java.simpleName
    val pre : MainPre = MainPre(this,this)
    val mContext = this
    var radioArray : Array<RadioButton>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioArray = arrayOf(
                activity_main_RadioButton_new_good,
                activity_main_RadioButton_boutique,
                activity_main_RadioButton_category,
                activity_main_RadioButton_cart,
                activity_main_RadioButton_personal_center
        )
        initChose()
        pre.setReceiver()
        if (FuLiCenterApp.initInstance().currentUser != null) {
            activity_main_TextView_cart_number.visibility = View.VISIBLE
        }else{
            activity_main_TextView_cart_number.visibility = View.GONE
        }
    }

    private fun initChose() {
        activity_main_RadioButton_new_good.isChecked = true
        activity_main_RadioGroup_group.setOnCheckedChangeListener { radioGroup, i -> 
            when(i){
                R.id.activity_main_RadioButton_new_good        -> {setViewPagerIndex(0)}
                R.id.activity_main_RadioButton_boutique        -> {setViewPagerIndex(1)}
                R.id.activity_main_RadioButton_category        -> {setViewPagerIndex(2)}
                R.id.activity_main_RadioButton_cart            -> {
                    if (FuLiCenterApp.initInstance().currentUser != null) {
                        setViewPagerIndex(3)
                    }else{
                        // go LoginActivity
                    }
                }
                R.id.activity_main_RadioButton_personal_center -> {
                    if (FuLiCenterApp.initInstance().currentUser != null) {
                        setViewPagerIndex(4)
                    }else{
                        // go LoginActivity
                        Log.e(TAG,"initChose "+"没有用户登录")
                    }
                }
            }
        }
        activity_main_ViewPager_fragmentViewpager.adapter = object : FragmentPagerAdapter(supportFragmentManager){
            override fun getCount(): Int {
                return radioArray!!.size
            }

            override fun getItem(position: Int): Fragment? {
                when(position){
                    0   ->  { return NewGoodsFragment()}
                    1   ->  { return BoutiqueFragment()}
                    2   ->  { return CategoryFragment()}
                    3   ->  { return CartFragment()}
                    4   ->  { return PersionalFragment()}
                }
                return null
            }

        }
        activity_main_ViewPager_fragmentViewpager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when{
                    position in 3..4 ->  {
                        if (FuLiCenterApp.initInstance().currentUser != null) {
                            radioArray!![position].isChecked = true
                        }else{
                            Log.e(TAG,"onPageSelected "+"没有用户登录")
                        }
                    }
                    else    ->  {
                        radioArray!![position].isChecked = true
                    }
                }
            }

        })
    }

    private fun setViewPagerIndex(i: Int) {
        activity_main_ViewPager_fragmentViewpager.currentItem = i
    }

    override fun onDestroy() {
        super.onDestroy()
        pre.unBindReceiver()
    }
    
    
    override fun setReceiver(cart_hint: String?) {
        if (cart_hint?.toInt() === 0){
            activity_main_TextView_cart_number.visibility = View.GONE
            return
        }else{
            activity_main_TextView_cart_number.text = cart_hint
        }
    }
}
