package ru.pyroman.medanalytica.feature.profile.vo

import ru.pyroman.medanalytica.domain.profile.domain.BloodType

class ProfileDataVo(
    val name: String,
    val surname: String,
    val dateOfBirth: DateOfBirthVo,
    val weight: String,
    val height: String,
    val bloodType: BloodType?,
)