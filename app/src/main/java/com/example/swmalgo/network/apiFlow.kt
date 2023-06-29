package com.example.swmalgo.network

import com.example.swmalgo.domain.model.ApiState
import com.example.swmalgo.domain.response.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

fun <T : Any> apiFlow(apiFunc: suspend () -> Response<ResponseWrapper<T>>): Flow<ApiState<ResponseWrapper<T>>> =
    flow {
        try {
            val res = apiFunc.invoke()
            if (res.isSuccessful) {
                emit(ApiState.Success(res.body() ?: throw NullPointerException()))
            } else {
//                val errorBody = res.errorBody() ?: throw NullPointerException()
//                emit(ApiState.Error(GsonHelper.stringToErrorResponse(errorBody = errorBody.string())))
                emit(ApiState.Error(res.errorBody().toString()))
            }
        } catch (e: Exception) {
            emit(ApiState.NotResponse(message = e.message ?: "", exception = e))
        }
    }.flowOn(Dispatchers.IO)