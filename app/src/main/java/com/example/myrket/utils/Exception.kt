package com.example.myrket.utils

import com.example.myrket.presentation.base.ResponseState

fun Int.resolveError() : ResponseState.Error = ResponseState.Error(
    message = when (this) {
        404 -> "Ошибка"
        500 -> "Ошибка"
        else -> "Ошибка"
    }
)