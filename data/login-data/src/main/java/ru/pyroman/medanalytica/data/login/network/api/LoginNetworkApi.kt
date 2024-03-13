package ru.pyroman.medanalytica.data.login.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import ru.pyroman.medanalytica.data.login.network.dto.LoginDataNetworkDto
import ru.pyroman.medanalytica.data.login.network.dto.LoginResultNetworkDto

internal interface LoginNetworkApi {

    @POST("/registration/authorize")
    suspend fun login(
        @Body loginDataNetworkDto: LoginDataNetworkDto,
    ): LoginResultNetworkDto

    companion object {
        private const val BASE_URL = "http://51.250.107.247:8080"

        fun build(): LoginNetworkApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginNetworkApi::class.java)
    }
}