package ru.pyroman.medanalytica.feature.formatter

import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphData
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphPoint
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphDataVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphListVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphPointVo

internal class AnalysisGraphFormatter {

    fun format(model: AnalysisGraphList): AnalysisGraphListVo {
        val graphs = model.graphs.map(::formatGraphData)

        return AnalysisGraphListVo(
            graphs = graphs,
        )
    }

    private fun formatGraphData(model: AnalysisGraphData): AnalysisGraphDataVo {
        val points = model.points.mapIndexed(::formatGraphPoint)

        return AnalysisGraphDataVo(
            analysisType = model.analysisType,
            points = points,
        )
    }

    private fun formatGraphPoint(
        index: Int,
        model: AnalysisGraphPoint
    ): AnalysisGraphPointVo {
        return AnalysisGraphPointVo(
            creationDateTime = model.creationDateTime,
            index = index.toFloat(),
            value = model.value,
        )
    }
}