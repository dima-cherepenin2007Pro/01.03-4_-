package com.example.cherepeninpr01.model

data class ProductResponse (
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>
)