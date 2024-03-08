package ru.pyroman.medanalytica.data.analysisgraph.network

import ru.pyroman.medanalytica.data.analysisgraph.network.api.AnalysisGraphNetworkApi
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphListNetworkDto

internal class AnalysisGraphNetworkDataSource(
    private val api: AnalysisGraphNetworkApi,
) {

    suspend fun getGraphList(
        uid: String,
    ): AnalysisGraphListNetworkDto {
        return api.getGraphList(uid)
    }
}