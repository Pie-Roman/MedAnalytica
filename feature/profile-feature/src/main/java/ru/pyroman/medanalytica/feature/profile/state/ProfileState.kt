package ru.pyroman.medanalytica.feature.profile.state

sealed class ProfileState {

    data object Idle : ProfileState()

    data object Loading : ProfileState()

    data class Failure(val message: String) : ProfileState()

    data object Error : ProfileState()
}