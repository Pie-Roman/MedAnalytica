package ru.pyroman.medanalytica.data.analysisgraph.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphListNetworkDto
import ru.pyroman.medanalytica.domain.uid.model.Uid

internal interface AnalysisGraphNetworkApi {

    @GET("bloodTest/bloodTests/all/{uid}")
    suspend fun getGraphList(
        @Path("uid") uid: Uid,
    ): AnalysisGraphListNetworkDto

    companion object {
        private const val BASE_URL = "http://51.250.107.247:8080"

        fun build(): AnalysisGraphNetworkApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnalysisGraphNetworkApi::class.java)
    }
}