package ru.pyroman.medanalytica.feature.login.state

sealed class LoginState {

    data object Idle : LoginState()

    data object Loading : LoginState()

    data object Success : LoginState()

    data object Failure : LoginState()

    data object Error : LoginState()
}