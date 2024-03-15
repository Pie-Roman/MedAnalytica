package ru.pyroman.medanalytica.feature.register.state

sealed class RegisterState {

    data object Idle : RegisterState()

    data object Loading : RegisterState()

    data class Failure(val message: String) : RegisterState()

    data object Error : RegisterState()
}