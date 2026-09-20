package com.example.cherepeninpr02.remote


import com.example.cherepeninpr02.model.CreateUserRequest
import com.example.cherepeninpr02.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("users/add")
    suspend fun addUser(
        @Body user: CreateUserRequest
    ): UserResponse
}