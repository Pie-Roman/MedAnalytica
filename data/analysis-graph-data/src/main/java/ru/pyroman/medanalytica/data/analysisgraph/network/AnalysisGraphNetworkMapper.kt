package ru.pyroman.medanalytica.data.analysisgraph.network

import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphDataNetworkDto
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphListNetworkDto
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphPointNetworkDto
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphData
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphPoint
import javax.inject.Inject

internal class AnalysisGraphNetworkMapper @Inject constructor() {

    fun map(dto: AnalysisGraphListNetworkDto): AnalysisGraphList {
       return requireNotNull(dto.graphs).mapNotNull { graphDataDto ->
            graphDataDto?.let { mapAnalysisGraphData(it) }
        }
    }

    private fun mapAnalysisGraphData(dto: AnalysisGraphDataNetworkDto): AnalysisGraphData {
        val analysisType = dto.type.orEmpty()
        val units = dto.units.orEmpty()
        val points = dto.values.orEmpty().mapNotNull { pointDto ->
            pointDto?.let { mapAnalysisGraphPoint(it) }
        }

        return AnalysisGraphData(
            analysisType = analysisType,
            units = units,
            points = points,
        )
    }

    private fun mapAnalysisGraphPoint(dto: AnalysisGraphPointNetworkDto): AnalysisGraphPoint {
        val creationDateTime = dto.creationDateTime.orEmpty()
        val value = dto.value ?: 0f

        return AnalysisGraphPoint(
            creationDateTime = creationDateTime,
            value = value,
        )
    }
}