package ru.pyroman.medanalytica.domain.analysisgraph.model

data class AnalysisGraphListData(
    val graphs: List<AnalysisGraphData>,
    val warning: AnalysisGraphListWarning?,
)