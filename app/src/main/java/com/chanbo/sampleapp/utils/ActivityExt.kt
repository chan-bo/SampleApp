package com.chanbo.sampleapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun isNetworkConnected(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnected
}

fun View.clipToStatusBar() {
    val statusBarHeight = getStatusBarHeight(context)
    layoutParams.height += statusBarHeight
    setPadding(0, statusBarHeight, 0, 0)
}

private fun getStatusBarHeight(context: Context): Int {
    var result = 0
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = context.resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun<T> AppCompatActivity.observeLiveData(liveData: LiveData<T>, function: (liveData: T?) -> Unit) {
    liveData.observe(this@observeLiveData, Observer {
        function(it)
    })
}

fun<T> Fragment.observeLiveData(liveData: LiveData<T>, function: (liveData: T?) -> Unit) {
    liveData.observe(this@observeLiveData, Observer {
        function(it)
    })
}