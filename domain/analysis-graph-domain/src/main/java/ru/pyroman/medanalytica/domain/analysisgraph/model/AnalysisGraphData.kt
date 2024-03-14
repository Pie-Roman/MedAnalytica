package ru.pyroman.medanalytica.domain.analysisgraph.model

data class AnalysisGraphData(
    val analysisType: String,
    val units: String,
    val points: List<AnalysisGraphPoint>,
)