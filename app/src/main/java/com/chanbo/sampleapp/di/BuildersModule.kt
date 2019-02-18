package com.chanbo.sampleapp.di

import com.chanbo.sampleapp.ui.detail.MovieDetailActivity
import com.chanbo.sampleapp.ui.main.MainActivity
import com.chanbo.sampleapp.ui.toprated.TopRatedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailActivity(): MovieDetailActivity

    @ContributesAndroidInjector
    abstract fun contributeTopRatedFragment(): TopRatedFragment
}