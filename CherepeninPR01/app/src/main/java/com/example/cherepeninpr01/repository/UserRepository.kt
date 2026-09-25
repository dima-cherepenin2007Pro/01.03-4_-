package com.example.cherepeninpr01.repository
import com.example.cherepeninpr01.remote.RetrofitInstance
import com.example.cherepeninpr01.model.User

class UserRepository {
    suspend fun addUser(user: User): User {
        return RetrofitInstance.apiUser.addUser(user)
    }
}