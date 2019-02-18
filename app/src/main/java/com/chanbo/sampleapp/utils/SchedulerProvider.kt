package com.chanbo.sampleapp.utils

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider {

    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(ioThread)
            .observeOn(uiThread)
    }

    private val ioThread = Schedulers.io()

    private val uiThread = AndroidSchedulers.mainThread()
}