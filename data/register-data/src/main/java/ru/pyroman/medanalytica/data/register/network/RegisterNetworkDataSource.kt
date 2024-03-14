package ru.pyroman.medanalytica.data.register.network

import ru.pyroman.medanalytica.data.register.network.api.RegisterNetworkApi
import ru.pyroman.medanalytica.data.register.network.dto.RegisterDataNetworkDto
import ru.pyroman.medanalytica.data.register.network.dto.RegisterResultNetworkDto
import javax.inject.Inject

internal class RegisterNetworkDataSource @Inject constructor(
    private val api: RegisterNetworkApi,
){

    suspend fun register(dto: RegisterDataNetworkDto): RegisterResultNetworkDto {
        return api.register(dto)
    }
}