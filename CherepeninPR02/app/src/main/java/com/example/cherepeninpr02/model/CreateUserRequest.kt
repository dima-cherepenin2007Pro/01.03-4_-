package com.example.cherepeninpr02.model

data class CreateUserRequest(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val address: String
)