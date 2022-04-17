package com.example.myrket.domain

import kotlinx.coroutines.Deferred

interface UseCaseExecutor {
    fun <TParams, TResult> UseCase<TParams, TResult>.execute(
        params: TParams,
        onObtain: suspend (TParams, Deferred<TResult>) -> Unit,
        onError: (Throwable) -> Unit,
        cancelPrevious: Boolean = true
    )
    fun cancelUseCaseJob()
}