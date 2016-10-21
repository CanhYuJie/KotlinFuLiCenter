package com.yujie.kotlinfulicenter

import android.app.Application
import android.content.pm.ApplicationInfo
import com.yujie.kotlinfulicenter.model.bean.Result

/**
 * Created by yujie on 16-10-21.
 */
class FuLiCenterApp : Application(){
    companion object{
        private var instance : FuLiCenterApp? = null
        fun initInstance() = instance!!
    }
    var currentUser : Result? = null
        get
        set(value) {
            this.currentUser = value
        }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}