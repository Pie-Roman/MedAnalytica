package ru.pyroman.medanalytica.postanalysis.feature.state

import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisResult

sealed class PostAnalysisState {

    data object Idle : PostAnalysisState()

    data object Loading : PostAnalysisState()

    class Success(
        val result: PostAnalysisResult,
    ) : PostAnalysisState()

    data object Error : PostAnalysisState()
}