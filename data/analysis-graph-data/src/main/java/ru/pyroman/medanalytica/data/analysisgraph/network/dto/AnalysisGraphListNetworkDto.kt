package ru.pyroman.medanalytica.data.analysisgraph.network.dto

import com.google.gson.annotations.SerializedName

internal data class AnalysisGraphListNetworkDto(
    @SerializedName("bloodTestsByTypeDtos")
    val graphs: List<AnalysisGraphDataNetworkDto?>?
)