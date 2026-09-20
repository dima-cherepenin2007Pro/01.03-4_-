package com.example.cherepeninpr02.model

data class UserResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val address: Address
)