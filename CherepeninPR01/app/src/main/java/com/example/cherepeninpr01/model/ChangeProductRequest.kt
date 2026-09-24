package com.example.cherepeninpr01.model

data class ChangeProductRequest(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>,
)