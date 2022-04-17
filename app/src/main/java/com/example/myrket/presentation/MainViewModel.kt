package com.example.myrket.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrket.domain.UseCaseExecutor
import com.example.myrket.domain.UseCaseExecutorImpl
import com.example.myrket.domain.usecase.GetPopularMovieUseCase
import com.example.myrket.presentation.model.TmdbMovie
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPopularMovieUseCase: GetPopularMovieUseCase
) : ViewModel(), UseCaseExecutor by UseCaseExecutorImpl() {

    private var _screenStateFlow: MutableStateFlow<MainScreenState> =
        MutableStateFlow(MainScreenState.Loading(true))

    val screenStateFlow: StateFlow<MainScreenState>
        get() = _screenStateFlow.asStateFlow()


    init {
        getMovies()
    }

    override fun onCleared() {
        cancelUseCaseJob()
    }

    fun getMovies() {
        viewModelScope.launch {
            getPopularMovieUseCase.execute(
                params = Unit,
                onObtain = { _, result ->
                    _screenStateFlow.value = MainScreenState.Loaded(result.await())
                },
                onError = { error ->
                    _screenStateFlow.value = MainScreenState.Error(error.message)
                })
        }
    }

    sealed class MainScreenState {
        data class Loading(val isShown: Boolean) : MainScreenState()
        data class Loaded(val movies: List<TmdbMovie>) : MainScreenState()
        data class Error(val error: String?) : MainScreenState()
    }

}