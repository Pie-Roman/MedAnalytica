package ru.pyroman.medanalytica.domain.start.repository

interface StartRepository {

    suspend fun isLoggedIn(): Boolean
}