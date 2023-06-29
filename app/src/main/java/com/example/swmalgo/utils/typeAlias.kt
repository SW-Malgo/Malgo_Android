package com.example.swmalgo.utils

import com.example.swmalgo.domain.model.ApiState
import com.example.swmalgo.domain.response.ResponseWrapper

typealias ApiWrapper<T> = ApiState<ResponseWrapper<T>>
