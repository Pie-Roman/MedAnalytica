package ru.pyroman.medanalytica.data.analysisgraph.network

import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphDataNetworkDto
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphPointNetworkDto
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphListNetworkDto
import javax.inject.Inject

internal class AnalysisGraphNetworkDataSource @Inject constructor() {

    suspend fun getGraphList(): AnalysisGraphListNetworkDto {
        return listOf(
            AnalysisGraphDataNetworkDto(
                type = "MCH",
                std = null,
                min = null,
                lastUpdatedAt = null,
                values = listOf(
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "25.01.24",
                        value = 29.015984196295115f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "01.02.24",
                        value = 29.50865727482566f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "14.02.24",
                        value = 29.442542479068127f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "25.02.24",
                        value = 27.93975153381725f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "03.03.24",
                        value = 29.161417639230358f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "25.01.24",
                        value = 30.563884907956215f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "01.02.24",
                        value = 34.44097615853632f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "14.02.24",
                        value = 30.987861593356058f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "25.02.24",
                        value = 29.523395305956754f,
                    ),
                    AnalysisGraphPointNetworkDto(
                        creationDateTime = "03.03.24",
                        value = 31.56601234680911f,
                    ),
                )
            )
        )
    }
}