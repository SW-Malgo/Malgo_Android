package com.example.swmalgo.domain.repository

import com.example.swmalgo.domain.response.SignUpResponse
import com.example.swmalgo.utils.ApiWrapper
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun signUp(): Flow<ApiWrapper<SignUpResponse>>
}