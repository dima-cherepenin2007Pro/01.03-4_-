package com.example.cherepeninpr01.remote

import android.media.session.MediaSession
import com.example.cherepeninpr01.model.PostsResponse
import com.example.cherepeninpr01.model.AuthRequest
import com.example.cherepeninpr01.model.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PostAPI {
    @POST("api/collections/users/auth-with-password")
    suspend fun auth(@Body body: AuthRequest): AuthResponse

    @GET("api/collections/posts/records")
    suspend fun getPosts(@Header("Authorization") token: String): PostsResponse
}