package ru.pyroman.medanalytica.data.analysisgraph.cache.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphPointCacheDto
import javax.inject.Inject

@ProvidedTypeConverter
internal class AnalysisGraphCacheTypeConverter @Inject constructor() {

    private val gson = Gson()
    private val typeToken = object : TypeToken<List<AnalysisGraphPointCacheDto>>() {}.type

    @TypeConverter
    fun pointListToString(points: List<AnalysisGraphPointCacheDto>): String {
        return gson.toJson(points)
    }

    @TypeConverter
    fun stringToPointList(string: String): List<AnalysisGraphPointCacheDto> {
        return gson.fromJson(string, typeToken)
    }
}