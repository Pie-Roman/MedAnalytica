package ru.pyroman.medanalytica.data.login.network

import ru.pyroman.medanalytica.data.login.network.api.LoginNetworkApi
import ru.pyroman.medanalytica.data.login.network.dto.LoginDataNetworkDto
import ru.pyroman.medanalytica.data.login.network.dto.LoginResultNetworkDto
import javax.inject.Inject

internal class LoginNetworkDataSource @Inject constructor(
    private val api: LoginNetworkApi,
){

    suspend fun login(dto: LoginDataNetworkDto): LoginResultNetworkDto {
        return api.login(dto)
    }
}