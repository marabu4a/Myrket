package com.example.myrket.domain

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class UseCaseExecutorImpl : UseCaseExecutor {

    private var useCaseJob: Job? = null

    override fun <TParams, TResult> UseCase<TParams, TResult>.execute(
        params: TParams,
        onObtain: suspend (TParams, Deferred<TResult>) -> Unit,
        onError: (Throwable) -> Unit,
        cancelPrevious: Boolean
    ) {
        if (cancelPrevious) cancelUseCaseJob()
        val scope = CoroutineScope(defaultDispatcher)
        useCaseJob = scope.launch {
            try {
                val deferredRusult = async(defaultDispatcher) {
                    call(params)
                }
                onObtain(params, deferredRusult)
                deferredRusult.await()
            } catch (e: CancellationException) {
                Log.e("CoroutineException", "${this.javaClass.simpleName} cancelled")
            } catch (e: Throwable) {
                onError(e)
            }
        }
    }

    fun <TParams, TResult> UseCase<TParams, TResult>.launchFlow(
        params: TParams,
        onError: (Throwable) -> Unit,
        cancelPrevious: Boolean
    ): Flow<TResult> {
        if (cancelPrevious) cancelUseCaseJob()
        val scope = CoroutineScope(defaultDispatcher)
        return flow<TResult> {
            emit(call(params))
        }
            .flowOn(defaultDispatcher)
            .catch { e ->
                onError(e)
            }
            .cancellable()
    }



    override fun cancelUseCaseJob() {
        useCaseJob?.cancelChildren()
        useCaseJob?.cancel()
        useCaseJob = null
    }
}