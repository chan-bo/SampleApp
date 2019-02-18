package com.chanbo.sampleapp.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.chanbo.sampleapp.App
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber

object Injector {

    fun init(app: App) {
        Timber.d("Injector inject")
        DaggerAppComponent.builder()
            .app(app)
            .build()
            .inject(app)

        app.registerActivityLifecycleCallbacks(
            object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                    injectActivity(activity)
                }

                override fun onActivityStarted(activity: Activity?) {

                }

                override fun onActivityResumed(activity: Activity?) {

                }

                override fun onActivityPaused(activity: Activity?) {

                }

                override fun onActivityStopped(activity: Activity?) {

                }

                override fun onActivityDestroyed(activity: Activity?) {

                }

                override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

                }
            }
        )
    }

    private fun injectActivity(activity: Activity?) {
        if (activity != null && activity is FragmentActivity) {
            AndroidInjection.inject(activity)
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                            fm: FragmentManager,
                            f: Fragment,
                            savedInstanceState: Bundle?
                        ) {
                            super.onFragmentCreated(fm, f, savedInstanceState)
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true
                )
        }
    }
}