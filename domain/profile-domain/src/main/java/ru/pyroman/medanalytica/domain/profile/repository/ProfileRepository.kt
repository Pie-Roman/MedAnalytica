package ru.pyroman.medanalytica.domain.profile.repository

import ru.pyroman.medanalytica.domain.profile.domain.ProfileData

interface ProfileRepository {

    suspend fun getProfileData(): ProfileData

    suspend fun patchProfileData(data: ProfileData)
}