package com.example.cherepeninpr01.remote

import com.example.cherepeninpr01.model.CreateUserRequest
import com.example.cherepeninpr01.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.PUT
import com.example.cherepeninpr01.model.ChangeProductRequest
import com.example.cherepeninpr01.model.ProductResponse
import retrofit2.http.Path

interface ProductAPI {
    @PUT("products/{id}")
    suspend fun changeProduct(@Path("id") id: Int, @Body product: ChangeProductRequest): ProductResponse
}