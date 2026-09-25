package com.example.cherepeninpr01.model

data class CreateUserRequest(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val address: UserAddress
)