package com.yujie.kotlinfulicenter.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.io.Serializable

/**
 * Created by yujie on 16-10-21.
 */
object ActivityUtils {

    fun <T>goNextActivity(context : Context, nextActivity : Class<T>,dataClass : Serializable? ,goKey : String?){
        val intent = Intent(context,nextActivity)
        val bundle = Bundle()
        if (dataClass != null) {
            bundle.putSerializable(goKey,dataClass)
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
    }
    fun <T>goNextActivity(context : Context, nextActivity : Class<T>){
        val intent = Intent(context,nextActivity)
        context.startActivity(intent)
    }

    fun finishActivity(context : AppCompatActivity){
        context.finish()
    }
}