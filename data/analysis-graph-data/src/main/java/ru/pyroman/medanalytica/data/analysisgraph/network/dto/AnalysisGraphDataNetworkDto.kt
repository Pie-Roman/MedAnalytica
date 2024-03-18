package ru.pyroman.medanalytica.data.analysisgraph.network.dto

import com.google.gson.annotations.SerializedName

internal data class AnalysisGraphDataNetworkDto(
    @SerializedName("type") val type: String?,
    @SerializedName("units") val units: String?,
    @SerializedName("valuesWithCreationDates") val values: List<AnalysisGraphPointNetworkDto?>?,
)