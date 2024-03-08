package ru.pyroman.medanalytica.data.analysisgraph.network.dto

import com.google.gson.annotations.SerializedName

internal data class AnalysisGraphDataNetworkDto(
    @SerializedName("type") val type: String?,
    @SerializedName("std") val std: Double?,
    @SerializedName("min") val min: Double?,
    @SerializedName("lastUpdatedAt") val lastUpdatedAt: Long?,
    @SerializedName("values") val values: List<AnalysisGraphPointNetworkDto?>?,
)