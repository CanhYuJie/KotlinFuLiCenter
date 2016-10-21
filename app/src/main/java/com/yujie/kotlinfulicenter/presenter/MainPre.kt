package com.yujie.kotlinfulicenter.presenter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import com.yujie.kotlinfulicenter.view.interfaces.IMainView

/**
 * Created by yujie on 16-10-21.
 */
class MainPre(val view : IMainView,val acitivity: AppCompatActivity) {
    var receiver : NumberCountReceiver? = null
    fun setReceiver(){
        receiver = NumberCountReceiver()
        val filter = IntentFilter("receiver_update_cart_hint")
        acitivity.registerReceiver(receiver,filter)
    }

    fun unBindReceiver(){
        acitivity.unregisterReceiver(receiver)
    }

    inner class NumberCountReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            val count = intent?.getStringExtra("cart_hint")
            view.setReceiver(count)
        }

    }
}