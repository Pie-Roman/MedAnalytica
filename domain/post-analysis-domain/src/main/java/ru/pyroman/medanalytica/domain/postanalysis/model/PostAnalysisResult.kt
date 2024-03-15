package ru.pyroman.medanalytica.domain.postanalysis.model

sealed class PostAnalysisResult {
    data object Success : PostAnalysisResult()

    data class Error(val message: String) : PostAnalysisResult()
}