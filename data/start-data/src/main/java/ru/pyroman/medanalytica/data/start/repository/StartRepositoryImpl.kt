package ru.pyroman.medanalytica.data.start.repository

import ru.pyroman.medanalytica.domain.start.repository.StartRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class StartRepositoryImpl @Inject internal constructor(
    private val uidRepository: UidRepository,
    private val tokenRepository: TokenRepository,
) : StartRepository {
    override suspend fun isLoggedIn(): Boolean {
        val uid = uidRepository.getUid()
        val token = tokenRepository.getToken()

        return uid != null && token != null
    }
}