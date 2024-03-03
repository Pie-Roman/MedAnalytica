package ru.pyroman.medanalytica.data.analysisgraph.network.dto

import com.google.gson.annotations.SerializedName

internal data class AnalysisGraphPointNetworkDto(
    @SerializedName("value") val value: Float?,
    @SerializedName("creationDateTime") val creationDateTime: String?,
)