package com.example.swmalgo.data.repository

import com.example.swmalgo.domain.repository.HomeRepository
import com.example.swmalgo.domain.request.SignUpRequest
import com.example.swmalgo.domain.response.SignUpResponse
import com.example.swmalgo.network.MalgoClient
import com.example.swmalgo.network.MalgoService
import com.example.swmalgo.network.apiFlow
import com.example.swmalgo.utils.ApiWrapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val malgoService: MalgoService
) : HomeRepository {
    override fun signUp(): Flow<ApiWrapper<SignUpResponse>> = apiFlow {
        malgoService.signUp(
            SignUpRequest(
                certificationId = "test@test.com",
                password = "test@123",
                code = "1234",
                keywords = listOf("야구")
            )
        )
    }


}