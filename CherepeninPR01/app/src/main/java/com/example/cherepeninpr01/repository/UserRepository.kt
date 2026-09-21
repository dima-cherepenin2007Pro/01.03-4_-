package com.example.cherepeninpr01.repository
import com.example.cherepeninpr01.model.CreateUserRequest
import com.example.cherepeninpr01.remote.RetrofitInstance
import com.example.cherepeninpr01.model.UserResponse

class UserRepository {
    suspend fun addUser(user: CreateUserRequest): UserResponse {
        return RetrofitInstance.api2.addUser(user)
    }
}