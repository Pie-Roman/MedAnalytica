package ru.pyroman.medanalytica.data.register.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import ru.pyroman.medanalytica.data.register.network.dto.RegisterDataNetworkDto
import ru.pyroman.medanalytica.data.register.network.dto.RegisterResultNetworkDto

internal interface RegisterNetworkApi {

    @POST("/registration/register")
    suspend fun register(
        @Body loginDataNetworkDto: RegisterDataNetworkDto,
    ): RegisterResultNetworkDto

    companion object {
        private const val BASE_URL = "http://51.250.107.247:8080"

        fun build(): RegisterNetworkApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RegisterNetworkApi::class.java)
    }
}