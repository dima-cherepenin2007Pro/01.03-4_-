package com.example.cherepeninpr01.model

data class AuthResponse (
    val token: String,
    val record: UserRecord
)

data class UserRecord(
    val id: String,
    val email: String,
    val firstName: String?,
    val lastName: String?,
)