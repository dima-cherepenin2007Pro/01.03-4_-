package com.example.cherepeninpr01.remote

import com.example.cherepeninpr01.model.CreateUserRequest
import com.example.cherepeninpr01.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("users/add")
    suspend fun addUser(@Body user: CreateUserRequest): UserResponse
}