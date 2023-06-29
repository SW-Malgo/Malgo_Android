package com.example.swmalgo.data.repository

import com.example.swmalgo.domain.repository.HomeRepository
import com.example.swmalgo.network.MalgoClient
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val malgoClient: MalgoClient
) : HomeRepository {

}