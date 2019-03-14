package com.chanbo.sampleapp.di

import com.chanbo.sampleapp.ui.detail.MovieDetailViewModel
import com.chanbo.sampleapp.ui.main.MainViewModel
import com.chanbo.sampleapp.ui.toprated.TopRatedViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {

    viewModel {
        MainViewModel()
    }

    viewModel {
        TopRatedViewModel(get())
    }

    viewModel {
        MovieDetailViewModel(get())
    }
}