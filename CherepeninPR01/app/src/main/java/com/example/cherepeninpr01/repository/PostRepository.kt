package com.example.cherepeninpr01.repository
import com.example.cherepeninpr01.model.AuthResponse
import com.example.cherepeninpr01.model.PostsResponse
import com.example.cherepeninpr01.remote.RetrofitPosts
import com.example.cherepeninpr01.model.AuthRequest

class PostRepository {
    suspend fun auth(email: String, password: String): AuthResponse {
        return RetrofitPosts.apiPost.auth(AuthRequest(identity = email, password = password))
    }

    suspend fun getPosts(token: String): PostsResponse {
        return RetrofitPosts.apiPost.getPosts()
    }
}