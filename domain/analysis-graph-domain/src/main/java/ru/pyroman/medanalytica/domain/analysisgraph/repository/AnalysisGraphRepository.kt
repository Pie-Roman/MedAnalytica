package ru.pyroman.medanalytica.domain.analysisgraph.repository

import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList

interface AnalysisGraphRepository {

    suspend fun getGraphList(): AnalysisGraphList
}