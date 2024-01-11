package com.example.project_application.model.request

data class RegisterRequest (
    val name: String,
    val email: String,
    val phone: String,
    val address: String,
    val password : String
)
