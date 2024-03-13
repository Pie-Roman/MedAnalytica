package ru.pyroman.medanalytica.domain.login.repository

import ru.pyroman.medanalytica.domain.login.model.LoginData
import ru.pyroman.medanalytica.domain.login.model.LoginResult

interface LoginRepository {

    suspend fun login(data: LoginData): LoginResult
}