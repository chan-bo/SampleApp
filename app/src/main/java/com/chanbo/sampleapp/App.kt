package com.chanbo.sampleapp

import android.app.Application
import com.chanbo.sampleapp.di.appModule
import com.chanbo.sampleapp.di.networkModule
import com.chanbo.sampleapp.di.viewModelModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            networkModule,
            appModule,
            viewModelModule
        ))

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}