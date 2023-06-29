package com.example.swmalgo.domain.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseWrapper<out T>(
    @Json(name = "data")
    val data: T,
    @Json(name = "code")
    val code: Boolean,
    @Json(name = "message")
    val message: String,
)