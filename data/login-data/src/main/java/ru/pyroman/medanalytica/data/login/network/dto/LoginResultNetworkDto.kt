package ru.pyroman.medanalytica.data.login.network.dto

import com.google.gson.annotations.SerializedName

class LoginResultNetworkDto(
    @SerializedName("userId") val uid: Long?,
    @SerializedName("token") val token: String?,
)