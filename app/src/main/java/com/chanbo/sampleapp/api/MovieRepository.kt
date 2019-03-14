package com.chanbo.sampleapp.api

import com.chanbo.sampleapp.api.callback.Result
import com.chanbo.sampleapp.data.MovieResponse
import com.chanbo.sampleapp.data.detail.MovieDetailResponse

class MovieRepository(
    private val api: MovieApi
) : BaseRepository(), Repository {

    override suspend fun getMovieDetail(apiKey: String, movieId: Int): Result<MovieDetailResponse> =
        apiCallback {
            api.getMovieDetailAsync(movieId, apiKey).await()
        }

    override suspend fun getTopRatedMovies(apiKey: String, page: Int): Result<MovieResponse> =
        apiCallback {
            api.getTopRatedMoviesAsync(apiKey, page).await()
        }
}