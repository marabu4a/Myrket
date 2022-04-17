package com.example.myrket.presentation.model

data class TmdbMovie(
    val id: Int,
    val voteAverage: Double,
    val title: String,
    val overView: String,
    val adult: Boolean
)