package ru.pyroman.medanalytica.feature.login.state

sealed class LoginState {

    data object Idle : LoginState()

    data object Loading : LoginState()

    data class Failure(
        val message: String,
    ) : LoginState()

    data object Error : LoginState()
}