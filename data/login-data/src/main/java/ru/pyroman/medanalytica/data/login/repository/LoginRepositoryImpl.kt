package ru.pyroman.medanalytica.data.login.repository

import retrofit2.HttpException
import ru.pyroman.medanalytica.common.utils.extractMessage
import ru.pyroman.medanalytica.data.login.network.LoginNetworkDataSource
import ru.pyroman.medanalytica.data.login.network.LoginNetworkMapper
import ru.pyroman.medanalytica.domain.login.model.LoginData
import ru.pyroman.medanalytica.domain.login.model.LoginResult
import ru.pyroman.medanalytica.domain.login.repository.LoginRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject internal constructor(
    private val networkDataSource: LoginNetworkDataSource,
    private val networkMapper: LoginNetworkMapper,
    private val uidRepository: UidRepository,
    private val tokenRepository: TokenRepository,
) : LoginRepository {
    override suspend fun login(data: LoginData): LoginResult {
        return try {
            val loginDataDto = networkMapper.map(data)
            val loginResultDto = networkDataSource.login(loginDataDto)

            val uid = requireNotNull(loginResultDto.uid)
            val token = requireNotNull(loginResultDto.token)

            uidRepository.setUid(uid)
            tokenRepository.setToken(token)

            LoginResult.Success
        } catch (error: Throwable) {
            val defaultMessage = "Ошибка авторизации!"
            val message = (error as? HttpException)?.let {
                error.extractMessage(defaultMessage)
            } ?: defaultMessage
            LoginResult.Failure(message)
        }
    }
}