package ru.pyroman.medanalytica.feature.register.state

sealed class RegisterState {

    data object Idle : RegisterState()

    data object Loading : RegisterState()

    data object Success : RegisterState()

    data object Failure : RegisterState()

    data object Error : RegisterState()
}