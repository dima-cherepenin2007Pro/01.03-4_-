package com.example.cherepeninpr01.model

data class UserResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val address: Address
)