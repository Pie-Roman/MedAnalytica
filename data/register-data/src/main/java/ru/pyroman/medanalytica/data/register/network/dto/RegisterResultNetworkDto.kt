package ru.pyroman.medanalytica.data.register.network.dto

import com.google.gson.annotations.SerializedName
import ru.pyroman.medanalytica.domain.token.model.Token
import ru.pyroman.medanalytica.domain.uid.model.Uid

class RegisterResultNetworkDto(
    @SerializedName("userId") val uid: Uid?,
    @SerializedName("token") val token: Token?,
)
