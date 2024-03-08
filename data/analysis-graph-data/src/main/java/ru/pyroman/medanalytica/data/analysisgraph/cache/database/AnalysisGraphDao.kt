package ru.pyroman.medanalytica.data.analysisgraph.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphDataCacheDto
import ru.pyroman.medanalytica.data.analysisgraph.cache.dto.AnalysisGraphListCacheDto

@Dao
internal interface AnalysisGraphDao {

    @Query("SELECT * FROM analysis_graph_table")
    suspend fun getGraphList(): List<AnalysisGraphDataCacheDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGraphList(graphList: AnalysisGraphListCacheDto)

    @Query("DELETE FROM analysis_graph_table")
    suspend fun deleteGraphList()
}