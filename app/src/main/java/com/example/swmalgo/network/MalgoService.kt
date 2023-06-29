package com.example.swmalgo.network

import com.example.swmalgo.domain.request.SignUpRequest
import com.example.swmalgo.domain.response.SignUpResponse
import com.example.swmalgo.utils.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface MalgoService {

    @POST("/member")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    ): NetworkResponse<SignUpResponse>

}