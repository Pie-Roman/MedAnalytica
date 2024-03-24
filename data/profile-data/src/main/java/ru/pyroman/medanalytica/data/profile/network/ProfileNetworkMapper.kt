package ru.pyroman.medanalytica.data.profile.network

import ru.pyroman.medanalytica.data.profile.network.dto.ProfileDataNetworkDto
import ru.pyroman.medanalytica.domain.profile.domain.BloodType
import ru.pyroman.medanalytica.domain.profile.domain.ProfileData

internal class ProfileNetworkMapper {

    fun map(model: ProfileData): ProfileDataNetworkDto {
        return ProfileDataNetworkDto(
            name = model.name,
            surname = model.surname,
            dateOfBirth = model.dateOfBirth,
            weight = model.weight,
            height = model.height,
            bloodType = model.bloodType?.let { mapBloodType(it) },
        )
    }

    fun map(dto: ProfileDataNetworkDto): ProfileData {
        return ProfileData(
            name = dto.name.orEmpty(),
            surname = dto.surname.orEmpty(),
            dateOfBirth = dto.dateOfBirth.orEmpty(),
            weight = dto.weight,
            height = dto.height,
            bloodType = dto.bloodType?.let { mapBloodType(it) }
        )
    }

    private fun mapBloodType(model: BloodType): String {
        return model.value
    }

    private fun mapBloodType(dto: String): BloodType? {
        return BloodType.fromValue(dto)
    }
}