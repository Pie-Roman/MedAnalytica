package ru.pyroman.medanalytica.data.analysisgraph.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ru.pyroman.medanalytica.data.analysisgraph.network.dto.AnalysisGraphListNetworkDto

internal interface AnalysisGraphNetworkApi {

    @GET("bloodTests/all/{uid}")
    suspend fun getGraphList(
        @Path("uid") uid: String,
    ): AnalysisGraphListNetworkDto

    companion object {
        private const val BASE_URL = ""

        fun build() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnalysisGraphNetworkApi::class.java)
    }
}