package ru.pyroman.medanalytica.data.register.repository

import ru.pyroman.medanalytica.data.register.network.RegisterNetworkDataSource
import ru.pyroman.medanalytica.data.register.network.RegisterNetworkMapper
import ru.pyroman.medanalytica.domain.register.model.RegisterData
import ru.pyroman.medanalytica.domain.register.model.RegisterResult
import ru.pyroman.medanalytica.domain.register.repository.RegisterRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class RegisterRepositoryImpl @Inject internal constructor(
    private val networkDataSource: RegisterNetworkDataSource,
    private val networkMapper: RegisterNetworkMapper,
    private val uidRepository: UidRepository,
    private val tokenRepository: TokenRepository,
) : RegisterRepository {
    override suspend fun register(data: RegisterData): RegisterResult {
        return try {
            val registerDataDto = networkMapper.map(data)
            val registerResultDto = networkDataSource.register(registerDataDto)

            val uid = requireNotNull(registerResultDto.uid)
            val token = requireNotNull(registerResultDto.token)

            uidRepository.setUid(uid)
            tokenRepository.setToken(token)

            RegisterResult.SUCCESS
        } catch (error: Throwable) {
            RegisterResult.FAILURE
        }
    }
}