package ru.pyroman.medanalytica.data.analysisgraph.cache

import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphDataCacheDto
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphListCacheDto
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphPointCacheDto
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphData
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphPoint
import javax.inject.Inject

internal class AnalysisGraphCacheMapper @Inject constructor() {

    fun map(dto: AnalysisGraphListCacheDto): AnalysisGraphList {
        val graphs = dto.map { graphDataDto ->
            mapAnalysisGraphData(graphDataDto)
        }

        return AnalysisGraphList(
            graphs = graphs,
        )
    }

    fun map(model: AnalysisGraphList): AnalysisGraphListCacheDto {
        return model.graphs.map(::mapAnalysisGraphData)
    }

    private fun mapAnalysisGraphData(dto: AnalysisGraphDataCacheDto): AnalysisGraphData {
        val analysisType = dto.type
        val points = dto.values.map(::mapAnalysisGraphPoint)

        return AnalysisGraphData(
            analysisType = analysisType,
            points = points,
        )
    }

    private fun mapAnalysisGraphData(model: AnalysisGraphData): AnalysisGraphDataCacheDto {
        val points = model.points.map(::mapAnalysisGraphPoint)

        return AnalysisGraphDataCacheDto(
            type = model.analysisType,
            values = points,
        )

    }

    private fun mapAnalysisGraphPoint(dto: AnalysisGraphPointCacheDto): AnalysisGraphPoint {
        val creationDateTime = dto.creationDateTime
        val value = dto.value

        return AnalysisGraphPoint(
            creationDateTime = creationDateTime,
            value = value,
        )
    }

    private fun mapAnalysisGraphPoint(model: AnalysisGraphPoint): AnalysisGraphPointCacheDto {
        return AnalysisGraphPointCacheDto(
            value = model.value,
            creationDateTime = model.creationDateTime,
        )
    }
}