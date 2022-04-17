package com.example.myrket.domain

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class UseCase<in TParams,out TResult> (
    val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    abstract suspend fun call(params: TParams) : TResult
}