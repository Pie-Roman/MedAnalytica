package ru.pyroman.medanalytica.data.analysisgraph.cache

import ru.pyroman.medanalytica.data.analysisgraph.cache.database.AnalysisGraphDao
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphListCacheDto
import javax.inject.Inject

internal class AnalysisGraphCacheDataSource @Inject constructor(
    private val dao: AnalysisGraphDao,
) {

    suspend fun getGraphList(): AnalysisGraphListCacheDto {
        return dao.getGraphList()
    }

    suspend fun setGraphList(graphList: AnalysisGraphListCacheDto) {
        dao.deleteGraphList()
        dao.insertGraphList(graphList)
    }
}