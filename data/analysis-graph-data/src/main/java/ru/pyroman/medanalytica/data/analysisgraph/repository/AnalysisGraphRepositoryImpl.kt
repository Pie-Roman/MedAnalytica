package ru.pyroman.medanalytica.data.analysisgraph.repository

import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheDataSource
import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheMapper
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository

internal class AnalysisGraphRepositoryImpl(
    private val cacheDataSource: AnalysisGraphCacheDataSource,
    private val cacheMapper: AnalysisGraphCacheMapper,
) : AnalysisGraphRepository {
    override suspend fun getGraphList(): AnalysisGraphList {
        return getGraphListFromCache()
    }

    private suspend fun getGraphListFromCache(): AnalysisGraphList {
        val graphListDto = cacheDataSource.getGraphList()
        return cacheMapper.map(graphListDto)
    }
}