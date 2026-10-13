package com.example.cherepeninpr01.model

data class PostsResponse(
    val items: List<Post>,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int
)