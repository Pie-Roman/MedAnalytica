package ru.pyroman.medanalytica.data.profile.network.dto

import com.google.gson.annotations.SerializedName

internal data class ProfileDataNetworkDto(
    @SerializedName("name") val name: String?,
    @SerializedName("surname") val surname: String?,
    @SerializedName("dateOfBirth") val dateOfBirth: String?,
    @SerializedName("weight") val weight: Int?,
    @SerializedName("height") val height: Int?,
    @SerializedName("bloodType") val bloodType: String?,
)