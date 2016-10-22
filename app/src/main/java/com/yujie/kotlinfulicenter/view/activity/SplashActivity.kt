package com.yujie.kotlinfulicenter.view.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.yujie.kotlinfulicenter.FuLiCenterApp
import com.yujie.kotlinfulicenter.R
import com.yujie.kotlinfulicenter.model.bean.Result
import com.yujie.kotlinfulicenter.utils.ActFinish
import com.yujie.kotlinfulicenter.utils.SpUtils
import com.yujie.kotlinfulicenter.utils.goNextActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    val TAG : String = this.javaClass.simpleName
    val mContext : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_anim)
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                goNextActivity(mContext,MainActivity::class.java,null,null)
                ActFinish(this@SplashActivity)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        activity_splash.startAnimation(alphaAnimation)
        var user = SpUtils.readObject(this,"current_user")
        if (user!=null && user is Result){
            FuLiCenterApp.initInstance().currentUser = user
        }else{
            Log.e(TAG,"onCreate :转换失败")
        }
    }
}
