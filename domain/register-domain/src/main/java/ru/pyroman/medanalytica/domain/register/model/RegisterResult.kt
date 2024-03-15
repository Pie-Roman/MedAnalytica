package ru.pyroman.medanalytica.domain.register.model

sealed class RegisterResult {

    data object Success : RegisterResult()

    data class Failure(val message: String) : RegisterResult()
}