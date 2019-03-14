package com.chanbo.sampleapp.api

import com.chanbo.sampleapp.api.callback.Result
import com.chanbo.sampleapp.data.MovieResponse
import com.chanbo.sampleapp.data.detail.MovieDetailResponse

interface Repository {

    companion object {
        private const val API_KEY = "bcc94b1a7fe4d2ac8a21513d1f62fbb7"
    }

    suspend fun getTopRatedMovies(
        apiKey: String = API_KEY,
        page: Int = 1
    ): Result<MovieResponse>

    suspend fun getMovieDetail(
        apiKey: String = API_KEY,
        movieId: Int
    ): Result<MovieDetailResponse>
}