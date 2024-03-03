package ru.pyroman.medanalytica.domain.analysisgraph.model

data class AnalysisGraphData(
    val analysisType: String,
    val points: List<AnalysisGraphPoint>,
)