package ru.pyroman.medanalytica.data.analysisgraph.repository

import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheDataSource
import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheMapper
import ru.pyroman.medanalytica.data.analysisgraph.network.AnalysisGraphNetworkDataSource
import ru.pyroman.medanalytica.data.analysisgraph.network.AnalysisGraphNetworkMapper
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphList
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphListData
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphListWarning
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class AnalysisGraphRepositoryImpl @Inject internal constructor(
    private val uidRepository: UidRepository,
    private val tokenRepository: TokenRepository,
    private val networkDataSource: AnalysisGraphNetworkDataSource,
    private val networkMapper: AnalysisGraphNetworkMapper,
    private val cacheDataSource: AnalysisGraphCacheDataSource,
    private val cacheMapper: AnalysisGraphCacheMapper,
) : AnalysisGraphRepository {
    override suspend fun fetchGraphList(): AnalysisGraphListData {
        return try {
            val graphListFromNetwork = getGraphListFromNetwork()
            setGraphListInCache(graphListFromNetwork)
            val graphListFromCache = getGraphListFromCache()
            AnalysisGraphListData(
                graphs = graphListFromCache,
                warning = null,
            )
        } catch (error: Throwable) {
            val graphListFromCache = getGraphListFromCache()
            AnalysisGraphListData(
                graphs = graphListFromCache,
                warning = AnalysisGraphListWarning.NETWORK_ERROR
            )
        }
    }

    override suspend fun searchGraphs(searchText: String): AnalysisGraphListData {
        val graphList =  searchGraphsInCache(searchText)
        return AnalysisGraphListData(
            graphs = graphList,
            warning = null,
        )
    }

    private suspend fun getGraphListFromNetwork(): AnalysisGraphList {
        val uid = requireNotNull(uidRepository.getUid())
        val token = requireNotNull(tokenRepository.getToken())
        val graphListDto = networkDataSource.getGraphList(uid, token)
        return networkMapper.map(graphListDto)
    }

    private suspend fun setGraphListInCache(graphList: AnalysisGraphList) {
        try {
            val dto = cacheMapper.mapToDto(graphList)
            cacheDataSource.setGraphList(dto)
        } catch (_: Throwable) {

        }
    }

    private suspend fun getGraphListFromCache(): AnalysisGraphList {
        val graphListDto = cacheDataSource.getGraphList()
        return cacheMapper.mapFromDto(graphListDto)
    }

    private suspend fun searchGraphsInCache(searchText: String): AnalysisGraphList {
        val graphListDto = cacheDataSource.searchGraphs(searchText)
        return cacheMapper.mapFromDto(graphListDto)
    }
}