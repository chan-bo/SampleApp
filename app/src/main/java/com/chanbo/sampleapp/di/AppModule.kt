package com.chanbo.sampleapp.di

import android.app.Application
import android.content.Context
import com.chanbo.sampleapp.api.MovieRepository
import com.chanbo.sampleapp.api.Repository
import com.chanbo.sampleapp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideRepository(repository: MovieRepository): Repository = repository

    @Provides
    @Singleton fun provideSchedulerProvider() = SchedulerProvider()
}