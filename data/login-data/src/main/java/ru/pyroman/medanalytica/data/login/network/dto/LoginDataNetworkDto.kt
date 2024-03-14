package ru.pyroman.medanalytica.data.login.network.dto

import com.google.gson.annotations.SerializedName

class LoginDataNetworkDto(
    @SerializedName("login") val login: String?,
    @SerializedName("password") val password: String?,
)