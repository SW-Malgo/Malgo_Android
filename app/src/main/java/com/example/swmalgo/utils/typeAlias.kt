package com.example.swmalgo.utils

import com.example.swmalgo.domain.model.ApiState
import com.example.swmalgo.domain.response.ResponseWrapper
import retrofit2.Response

typealias ApiWrapper<T> = ApiState<ResponseWrapper<T>>
typealias NetworkResponse<T> = Response<ResponseWrapper<T>>
