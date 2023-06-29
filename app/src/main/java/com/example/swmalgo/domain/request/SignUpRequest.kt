package com.example.swmalgo.domain.request

data class SignUpRequest(
    val certificationId: String,
    val code: String,
    val keywords: List<String>,
    val password: String
)