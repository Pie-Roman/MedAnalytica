package ru.pyroman.medanalytica.data.token.repository

import ru.pyroman.medanalytica.data.token.cache.TokenCacheDataSource
import ru.pyroman.medanalytica.domain.token.model.Token
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject internal constructor(
    private val cacheDataSource: TokenCacheDataSource,
) : TokenRepository {
    override suspend fun setToken(token: Token) {
        return cacheDataSource.setToken(token)
    }

    override suspend fun getToken(): Token? {
        return cacheDataSource.getToken()
    }

    override suspend fun clearToken() {
        return cacheDataSource.clearToken()
    }
}