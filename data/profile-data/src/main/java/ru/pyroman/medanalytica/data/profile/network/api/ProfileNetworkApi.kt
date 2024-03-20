package ru.pyroman.medanalytica.data.profile.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path
import ru.pyroman.medanalytica.data.profile.network.dto.ProfileDataNetworkDto
import ru.pyroman.medanalytica.domain.token.model.Token
import ru.pyroman.medanalytica.domain.uid.model.Uid

internal interface ProfileNetworkApi {

    @GET("/users/{uid}")
    suspend fun getProfileData(
        @Path("uid") uid: Uid,
        @Header("token") token: Token,
    ): ProfileDataNetworkDto

    @PATCH("/users/{uid}")
    suspend fun patchProfileData(
        @Path("uid") uid: Uid,
        @Header("token") token: Token,
        @Body data: ProfileDataNetworkDto
    )

    companion object {
        private const val BASE_URL = "http://51.250.107.247:8080"

        fun build(): ProfileNetworkApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProfileNetworkApi::class.java)
    }
}