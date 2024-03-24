package ru.pyroman.medanalytica.data.profile.repository

import ru.pyroman.medanalytica.data.profile.network.ProfileNetworkDataSource
import ru.pyroman.medanalytica.data.profile.network.ProfileNetworkMapper
import ru.pyroman.medanalytica.domain.profile.domain.ProfileData
import ru.pyroman.medanalytica.domain.profile.repository.ProfileRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject internal constructor(
    private val uidRepository: UidRepository,
    private val tokenRepository: TokenRepository,
    private val networkDataSource: ProfileNetworkDataSource,
    private val networkMapper: ProfileNetworkMapper,
) : ProfileRepository {

    override suspend fun getProfileData(): ProfileData {
        return getProfileDataFromNetwork()
    }

    override suspend fun patchProfileData(data: ProfileData) {
        return patchProfileDataInNetwork(data)
    }

    private suspend fun getProfileDataFromNetwork(): ProfileData {
        val uid = requireNotNull(uidRepository.getUid())
        val token = requireNotNull(tokenRepository.getToken())

        val dto = networkDataSource.getProfileData(
            uid = uid,
            token = token,
        )

        return networkMapper.map(dto)
    }

    private suspend fun patchProfileDataInNetwork(data: ProfileData) {
        val uid = requireNotNull(uidRepository.getUid())
        val token = requireNotNull(tokenRepository.getToken())

        val dto = networkMapper.map(data)

        return networkDataSource.patchProfileData(
            uid = uid,
            token = token,
            data = dto,
        )
    }
}