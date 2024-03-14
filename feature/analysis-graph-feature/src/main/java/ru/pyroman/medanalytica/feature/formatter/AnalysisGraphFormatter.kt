package ru.pyroman.medanalytica.feature.formatter

import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphData
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphPoint
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphDataVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphListVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphPointVo
import java.text.SimpleDateFormat
import java.util.Locale

internal class AnalysisGraphFormatter {

    private val dateParser = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
    private val dateFormat = SimpleDateFormat("dd-mm\nyyyy", Locale.getDefault())

    fun format(model: AnalysisGraphList): AnalysisGraphListVo {
        val graphs = model.map(::formatGraphData)

        return AnalysisGraphListVo(
            graphs = graphs,
        )
    }

    private fun formatGraphData(model: AnalysisGraphData): AnalysisGraphDataVo {
        val title = formatTitle(model)
        val points = model.points.mapIndexed(::formatGraphPoint)

        return AnalysisGraphDataVo(
            title = title,
            points = points,
        )
    }

    private fun formatTitle(model: AnalysisGraphData): String {
        return "${model.analysisType}, ${model.units}"
    }

    private fun formatGraphPoint(
        index: Int,
        model: AnalysisGraphPoint
    ): AnalysisGraphPointVo {
        return AnalysisGraphPointVo(
            creationDateTime = formatDate(model.creationDateTime),
            index = index.toFloat(),
            value = model.value,
        )
    }

    private fun formatDate(dateString: String): String {
        val date = requireNotNull(dateParser.parse(dateString))
        return dateFormat.format(date)
    }
}