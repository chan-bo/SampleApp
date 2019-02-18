package com.chanbo.sampleapp.utils

import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscription
import timber.log.Timber

class Subscriber<T> internal constructor() : Observer<T>, SingleObserver<T>, MaybeObserver<T>, CompletableObserver, org.reactivestreams.Subscriber<T>{

    override fun onSubscribe(s: Subscription?) {
        Timber.i("Request onSubscribe: $s")
    }

    override fun onSuccess(t: T) {
        Timber.i("Request onSuccess: $t")
    }

    override fun onComplete() {
        Timber.i("Request onComplete")
    }

    override fun onSubscribe(d: Disposable) {
        Timber.i("Request onSubscribe: $d")
    }

    override fun onNext(t: T) {
        Timber.i("Request onNext: $t")
    }

    override fun onError(e: Throwable) {
        Timber.i("Request onError: $e")
    }
    companion object {

        @JvmStatic
        fun <T> create(): Subscriber<in T> = Subscriber()
    }

}