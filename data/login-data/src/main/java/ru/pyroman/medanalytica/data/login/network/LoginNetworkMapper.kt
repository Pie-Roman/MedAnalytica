package ru.pyroman.medanalytica.data.login.network

import ru.pyroman.medanalytica.data.login.network.dto.LoginDataNetworkDto
import ru.pyroman.medanalytica.domain.login.model.LoginData

class LoginNetworkMapper {

    fun map(model: LoginData): LoginDataNetworkDto {
        return LoginDataNetworkDto(
            login = model.login,
            password = model.password,
        )
    }
}