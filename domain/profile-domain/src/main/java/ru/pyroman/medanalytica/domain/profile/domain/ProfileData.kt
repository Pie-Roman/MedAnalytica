package ru.pyroman.medanalytica.domain.profile.domain

data class ProfileData(
    val name: String,
    val surname: String,
    val dateOfBirth: String,
    val weight: Int?,
    val height: Int?,
    val bloodType: BloodType?,
)