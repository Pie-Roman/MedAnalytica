package ru.pyroman.medanalytica.data.postanalysis.network

import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisData
import java.util.UUID

class PostAnalysisNetworkMapper {

    fun map(data: PostAnalysisData): RequestBody {
        val boundary = UUID.randomUUID().toString()
        val file = data.file
        val fileName = file.name
        val fileRequestHeaders = Headers.of(
            "Content-Disposition", "form-data; name=\"file\"; filename=${fileName}"
        )
        val fileRequestBody = RequestBody.create(
            MediaType.parse("application/pdf"),
            file,
        )

        return MultipartBody.Builder(boundary)
            .setType(MultipartBody.FORM)
            .addPart(
                fileRequestHeaders,
                fileRequestBody,
            )
            .build()
    }
}