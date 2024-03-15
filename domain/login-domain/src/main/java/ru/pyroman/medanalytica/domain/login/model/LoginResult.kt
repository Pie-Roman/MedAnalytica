package ru.pyroman.medanalytica.domain.login.model

sealed class LoginResult {
    data object Success : LoginResult()
    data class Failure(
        val message: String,
    ) : LoginResult()
}