package ru.pyroman.medanalytica.domain.token.repository

import ru.pyroman.medanalytica.domain.token.model.Token

interface TokenRepository {

    suspend fun setToken(token: Token)

    suspend fun getToken(): Token?
}