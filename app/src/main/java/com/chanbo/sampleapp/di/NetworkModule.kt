package com.chanbo.sampleapp.di

import com.chanbo.sampleapp.api.MovieApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideMovieApi(client: OkHttpClient): MovieApi =
            Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MovieApi::class.java)

    @Provides
    @Singleton
    internal fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build()

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor {
                Timber.i(it)
            }.setLevel(HttpLoggingInterceptor.Level.BODY)
}