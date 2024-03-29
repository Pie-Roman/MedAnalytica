package ru.pyroman.medanalytica.data.analysisgraph.cache

import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphDataCacheDto
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphListCacheDto
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphPointCacheDto
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphData
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphPoint
import javax.inject.Inject

internal class AnalysisGraphCacheMapper @Inject constructor() {

    fun mapFromDto(dto: AnalysisGraphListCacheDto): AnalysisGraphList {
        return dto.map { graphDataDto ->
            mapAnalysisGraphData(graphDataDto)
        }
    }

    fun mapToDto(model: AnalysisGraphList): AnalysisGraphListCacheDto {
        return model.map(::mapAnalysisGraphData)
    }

    private fun mapAnalysisGraphData(dto: AnalysisGraphDataCacheDto): AnalysisGraphData {
        val analysisType = dto.type
        val units = dto.units
        val points = dto.values.map(::mapAnalysisGraphPoint)

        return AnalysisGraphData(
            analysisType = analysisType,
            units = units,
            points = points,
        )
    }

    private fun mapAnalysisGraphData(model: AnalysisGraphData): AnalysisGraphDataCacheDto {
        val points = model.points.map(::mapAnalysisGraphPoint)

        return AnalysisGraphDataCacheDto(
            type = model.analysisType,
            units = model.units,
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