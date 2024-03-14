package ru.pyroman.medanalytica.domain.register.model

class RegisterData(
    val login: String,
    val password: String,
    val name: String? = null,
    val surname: String? = null,
    val dateOfBirth: String? = null,
    val weight: Int? = null,
    val height: Int? = null,
)