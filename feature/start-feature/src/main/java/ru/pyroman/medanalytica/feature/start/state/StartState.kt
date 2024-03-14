package ru.pyroman.medanalytica.feature.start.state

sealed class StartState {

    data object Idle: StartState()

    data object Loading : StartState()

    data object ProceedNext : StartState()

    data object NotLoggedIn : StartState()

    data object Error : StartState()
}