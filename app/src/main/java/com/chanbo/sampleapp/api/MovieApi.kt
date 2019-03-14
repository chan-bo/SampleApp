package com.chanbo.sampleapp.api

import com.chanbo.sampleapp.data.MovieResponse
import com.chanbo.sampleapp.data.detail.MovieDetailResponse
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getTopRatedMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Deferred<Response<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getMovieDetailAsync(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("append_to_response") appendToResponse: String = "images,credits"
    ) : Deferred<Response<MovieDetailResponse>>
}