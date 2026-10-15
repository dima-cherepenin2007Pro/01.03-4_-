package com.example.cherepeninpr01.repository
import com.example.cherepeninpr01.model.AuthResponse
import com.example.cherepeninpr01.model.PostsResponse
import com.example.cherepeninpr01.remote.RetrofitPosts
import com.example.cherepeninpr01.model.AuthRequest

class PostRepository {
    suspend fun auth(authData: AuthRequest): AuthResponse {
        return RetrofitPosts.apiPost.auth(authData)
    }

    suspend fun getPosts(token: String): PostsResponse {
        return RetrofitPosts.apiPost.getPosts(token)
    }
}