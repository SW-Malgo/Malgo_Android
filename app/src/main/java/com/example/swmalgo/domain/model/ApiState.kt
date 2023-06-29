package com.example.swmalgo.domain.model

sealed class ApiState<out T : Any> {
    data class Success<T : Any>(val data: T) : ApiState<T>()
    data class Error(val errorResponse: String) : ApiState<Nothing>()
    data class NotResponse(val message: String?, val exception: Throwable? = null) :
        ApiState<Nothing>()

    object Loading : ApiState<Nothing>()

    fun onSuccess(onSuccess: (T) -> Unit) {
        if (this is Success) {
            onSuccess(this@ApiState.data)
        }
    }

    fun onError(onError: (String) -> Unit) {
        if (this is Error) {
            onError(this@ApiState.errorResponse)
        }
        if (this is NotResponse) {
            onError("응답하지 않는 요청입니다.")
        }
    }

    fun onLoading(onLoading: () -> Unit) {
        if (this is Loading) {
            onLoading()
        }
    }
}