package com.example.cherepeninpr02.repository

import com.example.cherepeninpr02.model.CreateUserRequest
import com.example.cherepeninpr02.model.UserResponse
import com.example.cherepeninpr02.remote.RetrofitInstance

class UserRepository {

    suspend fun addUser(user: CreateUserRequest): UserResponse {
        return RetrofitInstance.api.addUser(user)
    }
}