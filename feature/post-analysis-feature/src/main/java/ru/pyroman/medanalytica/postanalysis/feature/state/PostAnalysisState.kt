package ru.pyroman.medanalytica.postanalysis.feature.state

sealed class PostAnalysisState {

    data object Idle : PostAnalysisState()

    data object Loading : PostAnalysisState()

    data class Error(val message: String) : PostAnalysisState()
}