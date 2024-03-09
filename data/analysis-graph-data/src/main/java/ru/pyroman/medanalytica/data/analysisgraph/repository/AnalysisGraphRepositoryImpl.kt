package ru.pyroman.medanalytica.data.analysisgraph.repository

import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheDataSource
import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheMapper
import ru.pyroman.medanalytica.data.analysisgraph.network.AnalysisGraphNetworkDataSource
import ru.pyroman.medanalytica.data.analysisgraph.network.AnalysisGraphNetworkMapper
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository
import javax.inject.Inject

class AnalysisGraphRepositoryImpl @Inject internal constructor(
    private val networkDataSource: AnalysisGraphNetworkDataSource,
    private val networkMapper: AnalysisGraphNetworkMapper,
    private val cacheDataSource: AnalysisGraphCacheDataSource,
    private val cacheMapper: AnalysisGraphCacheMapper,
) : AnalysisGraphRepository {
    override suspend fun getGraphList(): AnalysisGraphList {
        val graphListFromNetwork = getGraphListFromNetwork()
        setGraphListInCache(graphListFromNetwork)
        return getGraphListFromCache()
    }

    private suspend fun getGraphListFromNetwork(): AnalysisGraphList {
        val graphListDto = networkDataSource.getGraphList()
        return networkMapper.map(graphListDto)
    }

    private suspend fun setGraphListInCache(graphList: AnalysisGraphList) {
        val dto = cacheMapper.map(graphList)
        cacheDataSource.setGraphList(dto)
    }

    private suspend fun getGraphListFromCache(): AnalysisGraphList {
        val graphListDto = cacheDataSource.getGraphList()
        return cacheMapper.map(graphListDto)
    }
}