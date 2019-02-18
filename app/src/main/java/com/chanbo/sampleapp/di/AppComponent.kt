package com.chanbo.sampleapp.di

import android.app.Application
import com.chanbo.sampleapp.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        BuildersModule::class,
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}