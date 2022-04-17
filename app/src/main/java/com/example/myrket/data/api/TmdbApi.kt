package com.example.myrket.data.api

import com.example.myrket.data.model.TmdbMovieNw
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {

    @GET("movie/popular")
    fun getPopularMovie() : Response<List<TmdbMovieNw>>

    @GET("movie/{id}")
    fun getMovieById(@Path("id") id: Int): Response<TmdbMovieNw>

}