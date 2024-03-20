package ru.pyroman.medanalytica.data.profile.network

import ru.pyroman.medanalytica.data.profile.network.api.ProfileNetworkApi
import ru.pyroman.medanalytica.data.profile.network.dto.ProfileDataNetworkDto
import ru.pyroman.medanalytica.domain.token.model.Token
import ru.pyroman.medanalytica.domain.uid.model.Uid

internal class ProfileNetworkDataSource(
    private val api: ProfileNetworkApi
) {

    suspend fun getProfileData(
        uid: Uid,
        token: Token,
    ): ProfileDataNetworkDto {
        return api.getProfileData(
            uid = uid,
            token = token,
        )
    }

    suspend fun patchProfileData(
        uid: Uid,
        token: Token,
        data: ProfileDataNetworkDto
    ) {
        return api.patchProfileData(
            uid = uid,
            token = token,
            data = data,
        )
    }
}