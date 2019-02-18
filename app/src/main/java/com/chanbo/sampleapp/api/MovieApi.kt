package com.chanbo.sampleapp.api

import com.chanbo.sampleapp.data.MovieResponse
import com.chanbo.sampleapp.data.detail.MovieDetailResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("append_to_response") appendToResponse: String = "images,credits"
    ) : Observable<MovieDetailResponse>
}