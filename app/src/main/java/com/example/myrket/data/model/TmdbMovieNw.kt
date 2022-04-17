package com.example.myrket.data.model

import com.example.myrket.presentation.model.TmdbMovie

data class TmdbMovieNw(
    val id: Int,
    val voteAverage: Double,
    val title: String,
    val overView: String,
    val adult: Boolean
)


fun TmdbMovieNw.toTmdbMovie() = TmdbMovie(
    id = id,
    voteAverage = voteAverage,
    title = title,
    overView = overView,
    adult = adult
)