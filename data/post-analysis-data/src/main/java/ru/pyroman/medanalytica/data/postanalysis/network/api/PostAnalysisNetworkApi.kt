package ru.pyroman.medanalytica.data.postanalysis.network.api

import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import ru.pyroman.medanalytica.domain.uid.model.Uid

internal interface PostAnalysisNetworkApi {

    @POST("bloodTest/bloodTests/save/{uid}")
    suspend fun getGraphList(
        @Path("uid") uid: Uid,
        @Body body: RequestBody,
    )

    companion object {
        private const val BASE_URL = "http://51.250.107.247:8080"

        fun build(): PostAnalysisNetworkApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostAnalysisNetworkApi::class.java)
    }
}