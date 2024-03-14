package ru.pyroman.medanalytica.data.postanalysis.network

import ru.pyroman.medanalytica.data.postanalysis.network.api.PostAnalysisNetworkApi
import ru.pyroman.medanalytica.data.postanalysis.network.dto.PostAnalysisNetworkDto
import ru.pyroman.medanalytica.domain.token.model.Token
import ru.pyroman.medanalytica.domain.uid.model.Uid
import javax.inject.Inject

internal class PostAnalysisNetworkDataSource @Inject constructor(
    private val api: PostAnalysisNetworkApi,
) {

    suspend fun postAnalysis(
        uid: Uid,
        token: Token,
        postAnalysis: PostAnalysisNetworkDto,
    ) {
        api.getGraphList(
            uid = uid,
            token = token,
            postAnalysis = postAnalysis,
        )
    }
}