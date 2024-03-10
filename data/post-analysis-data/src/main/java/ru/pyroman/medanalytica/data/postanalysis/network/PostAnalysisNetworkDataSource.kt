package ru.pyroman.medanalytica.data.postanalysis.network

import okhttp3.RequestBody
import ru.pyroman.medanalytica.data.postanalysis.network.api.PostAnalysisNetworkApi
import ru.pyroman.medanalytica.domain.uid.model.Uid
import javax.inject.Inject

internal class PostAnalysisNetworkDataSource @Inject constructor(
    private val api: PostAnalysisNetworkApi,
) {

    suspend fun postAnalysis(
        uid: Uid,
        requestBody: RequestBody,
    ) {
        api.getGraphList(
            uid = uid,
            body = requestBody,
        )
    }
}