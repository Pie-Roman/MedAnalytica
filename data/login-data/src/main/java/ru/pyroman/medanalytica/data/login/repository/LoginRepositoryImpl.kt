package ru.pyroman.medanalytica.data.login.repository

import ru.pyroman.medanalytica.data.login.network.LoginNetworkDataSource
import ru.pyroman.medanalytica.data.login.network.LoginNetworkMapper
import ru.pyroman.medanalytica.domain.login.model.LoginData
import ru.pyroman.medanalytica.domain.login.model.LoginResult
import ru.pyroman.medanalytica.domain.login.repository.LoginRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject internal constructor(
    private val networkDataSource: LoginNetworkDataSource,
    private val networkMapper: LoginNetworkMapper,
    private val uidRepository: UidRepository,
) : LoginRepository {
    override suspend fun login(data: LoginData): LoginResult {
        return try {
            val loginDataDto = networkMapper.map(data)
            val loginResultDto = networkDataSource.login(loginDataDto)

            val uid = requireNotNull(loginResultDto.uid)

            uidRepository.setUid(uid)

            LoginResult.SUCCESS
        } catch (error: Throwable) {
            LoginResult.FAILURE
        }
    }
}