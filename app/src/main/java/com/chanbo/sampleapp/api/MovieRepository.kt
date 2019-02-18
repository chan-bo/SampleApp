package com.chanbo.sampleapp.api

import com.chanbo.sampleapp.data.MovieResponse
import com.chanbo.sampleapp.data.detail.MovieDetailResponse
import com.chanbo.sampleapp.utils.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: MovieApi,
    private val provider: SchedulerProvider
) : Repository {

    override fun getMovieDetail(apiKey: String, movieId: Int): Observable<MovieDetailResponse> =
        api.getMovieDetail(movieId, apiKey)
            .compose(provider.ioToMainObservableScheduler())

    override fun getTopRatedMovies(apiKey: String, page: Int): Observable<MovieResponse> =
         api.getTopRatedMovies(apiKey, page)
             .compose(provider.ioToMainObservableScheduler())
}