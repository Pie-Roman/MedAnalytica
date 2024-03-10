package ru.pyroman.medanalytica.domain.analysisgraph.repository

import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphListData

interface AnalysisGraphRepository {

    suspend fun fetchGraphList(): AnalysisGraphListData

    suspend fun searchGraphs(searchText: String): AnalysisGraphListData
}