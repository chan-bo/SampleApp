package com.chanbo.sampleapp.di

import com.chanbo.sampleapp.api.MovieRepository
import com.chanbo.sampleapp.api.Repository
import org.koin.dsl.module.module

val appModule = module {

    single<Repository> { MovieRepository(get()) }
}