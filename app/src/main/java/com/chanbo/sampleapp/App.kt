package com.chanbo.sampleapp

import android.app.Activity
import android.app.Application
import com.chanbo.sampleapp.di.Injector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}