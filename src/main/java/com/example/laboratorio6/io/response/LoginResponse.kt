package com.example.laboratorio6.io.response

import com.example.laboratorio6.model.User

data class LoginResponse(
    val succes: Boolean,
    val user: User,
    val jwt: String
)
