package ru.pyroman.medanalytica.data.postanalysis.repository

import ru.pyroman.medanalytica.data.postanalysis.network.PostAnalysisNetworkDataSource
import ru.pyroman.medanalytica.data.postanalysis.network.PostAnalysisNetworkMapper
import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisData
import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisResult
import ru.pyroman.medanalytica.domain.postanalysis.repository.PostAnalysisRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class PostAnalysisRepositoryImpl @Inject internal constructor(
    private val uidRepository: UidRepository,
    private val networkDataSource: PostAnalysisNetworkDataSource,
    private val networkMapper: PostAnalysisNetworkMapper,
) : PostAnalysisRepository {

    override suspend fun postAnalysis(data: PostAnalysisData): PostAnalysisResult {
        return try {
            val uid = requireNotNull(uidRepository.getUid())
            val requestBody = networkMapper.map(data)
            networkDataSource.postAnalysis(
                uid = uid,
                requestBody = requestBody,
            )
            PostAnalysisResult.SUCCESS
        } catch (error: Throwable) {
            PostAnalysisResult.FAILURE
        }
    }
}