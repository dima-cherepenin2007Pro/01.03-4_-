package com.example.cherepeninpr01.model

data class User(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val address: UserAddress
)