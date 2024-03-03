package ru.pyroman.medanalytica.data.analysisgraph.cache.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphDataCacheDto

@Database(entities = [AnalysisGraphDataCacheDto::class], version = 1)
@TypeConverters(AnalysisGraphCacheTypeConverter::class)
internal abstract class AnalysisGraphDatabase : RoomDatabase() {

    abstract fun dao(): AnalysisGraphDao

    companion object {
        fun build(
            application: Application,
            typeConverter: AnalysisGraphCacheTypeConverter,
        ) = Room
            .databaseBuilder(
                context = application,
                klass = AnalysisGraphDatabase::class.java,
                name = "analysis_graph_database",
            )
            .fallbackToDestructiveMigration()
            .addTypeConverter(typeConverter)
            .build()
    }
}