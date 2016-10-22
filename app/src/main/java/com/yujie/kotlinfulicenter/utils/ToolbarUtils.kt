package com.yujie.kotlinfulicenter.utils

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.Toolbar
import com.yujie.kotlinfulicenter.R

/**
 * Created by yujie on 16-10-21.
 */
object ToolbarUtils {
    /**
     * return a toolbar with params
     */
    val TAG : String = this.javaClass.simpleName
    fun setToolbar(toolbar: Toolbar, title: String, icon: Int) {
        toolbar.title = title
        toolbar.setNavigationIcon(icon)
        toolbar.inflateMenu(R.menu.toolbar_menu)
    }
}