package com.example.myrket.utils

import com.example.myrket.presentation.base.ResponseState
import retrofit2.Response

fun <T: Any> safeApiCall(
    call: () -> Response<T>
) : ResponseState<T> {
    val result = call.invoke()

    return if (result.isSuccessful) {
        ResponseState.Success(result.body())
    } else {
        result.code().resolveError()
    }
}