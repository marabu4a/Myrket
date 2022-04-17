package com.example.myrket.presentation.base

sealed class ResponseState<out T> {
    data class Error(val message: String? = null) : ResponseState<Nothing>()
    data class Success<T: Any>(val result: T? = null) : ResponseState<T>()
}