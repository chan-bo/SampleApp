package com.chanbo.sampleapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chanbo.sampleapp.ui.detail.MovieDetailViewModel
import com.chanbo.sampleapp.ui.main.MainViewModel
import com.chanbo.sampleapp.ui.toprated.TopRatedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TopRatedViewModel::class)
    abstract fun bindTopRatedViewModel(topRatedViewModel: TopRatedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel
}