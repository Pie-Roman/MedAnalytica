package ru.pyroman.medanalytica.common.utils

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException

fun HttpException.extractMessage(
    defaultMessage: String,
): String {
    val body = response()?.errorBody() ?: return defaultMessage
    val gson = Gson()
    val type = object : TypeToken<ErrorResponse>() {}.type

    return gson.fromJson<ErrorResponse>(body.charStream(), type).message ?: defaultMessage
}

private data class ErrorResponse(
    @SerializedName("message") val message: String?
)