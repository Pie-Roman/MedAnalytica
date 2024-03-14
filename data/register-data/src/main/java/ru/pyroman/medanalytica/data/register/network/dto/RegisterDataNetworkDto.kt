package ru.pyroman.medanalytica.data.register.network.dto

import com.google.gson.annotations.SerializedName

class RegisterDataNetworkDto(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: String?,
    @SerializedName("surname") val surname: String?,
    @SerializedName("dateOfBirth") val dateOfBirth: String?,
    @SerializedName("weight") val weight: Int?,
    @SerializedName("height") val height: Int?,
)