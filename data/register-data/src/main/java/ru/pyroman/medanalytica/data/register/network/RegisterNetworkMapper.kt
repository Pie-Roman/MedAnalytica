package ru.pyroman.medanalytica.data.register.network

import ru.pyroman.medanalytica.data.register.network.dto.RegisterDataNetworkDto
import ru.pyroman.medanalytica.domain.register.model.RegisterData

class RegisterNetworkMapper {

    fun map(model: RegisterData): RegisterDataNetworkDto {
        return RegisterDataNetworkDto(
            login = model.login,
            password = model.password,
            name = model.password,
            surname = model.surname,
            dateOfBirth = model.dateOfBirth,
            weight = model.weight,
            height = model.height,
        )
    }
}