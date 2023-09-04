package com.example.laboratorio6.model

/*
        "id": 1,
        "name": "Reynaldo",
        "email": "rey@gmail.com",
        "email_verified_at": "2022-07-30T20:51:26.000000Z",
        "cedula": "04000000712",
        "address": "Av. Universitaria",
        "Phone": "0968000009",
        "role": "admin",
 */

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val cedula: String,
    val address: String,
    val Phone: String,
    val role: String
)
