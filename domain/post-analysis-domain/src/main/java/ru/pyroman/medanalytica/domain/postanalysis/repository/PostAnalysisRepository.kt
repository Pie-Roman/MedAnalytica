package ru.pyroman.medanalytica.domain.postanalysis.repository

import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisData
import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisResult

interface PostAnalysisRepository {

    suspend fun postAnalysis(data: PostAnalysisData): PostAnalysisResult
}