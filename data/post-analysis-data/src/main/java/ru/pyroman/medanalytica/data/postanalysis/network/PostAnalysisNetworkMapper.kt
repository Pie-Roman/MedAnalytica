package ru.pyroman.medanalytica.data.postanalysis.network

import ru.pyroman.medanalytica.data.postanalysis.network.dto.PostAnalysisNetworkDto
import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisData

class PostAnalysisNetworkMapper {

    fun map(data: PostAnalysisData): PostAnalysisNetworkDto {

        return PostAnalysisNetworkDto(
            file = data.file,
        )
    }
}