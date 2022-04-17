package com.example.myrket.domain.usecase

import com.example.myrket.data.api.TmdbApi
import com.example.myrket.data.model.toTmdbMovie
import com.example.myrket.domain.UseCase
import com.example.myrket.presentation.base.ResponseState
import com.example.myrket.presentation.model.TmdbMovie
import com.example.myrket.utils.resolveError
import com.example.myrket.utils.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
    private val tmdbApi: TmdbApi
) : UseCase<Unit, List<TmdbMovie>>() {

    override suspend fun call(params: Unit): List<TmdbMovie> {
        val result = tmdbApi.getPopularMovie()

        return if (result.isSuccessful) {
            val movies = result.body()?.map { it.toTmdbMovie() } ?: emptyList()
            movies
        } else {
            throw Exception(result.errorBody().toString())
        }
    }

}