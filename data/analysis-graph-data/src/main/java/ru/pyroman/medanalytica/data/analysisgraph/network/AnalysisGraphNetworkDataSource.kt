package ru.pyroman.medanalytica.data.analysisgraph.network

import ru.pyroman.medanalytica.data.analysisgraph.network.api.AnalysisGraphNetworkApi
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphListNetworkDto
import ru.pyroman.medanalytica.domain.uid.model.Uid
import javax.inject.Inject

internal class AnalysisGraphNetworkDataSource @Inject constructor(
    private val api: AnalysisGraphNetworkApi,
)  {

    suspend fun getGraphList(uid: Uid): AnalysisGraphListNetworkDto {
        return api.getGraphList(uid)
    }
}