package ru.pyroman.medanalytica.data.analysisgraph.cache.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "analysis_graph_table")
internal data class AnalysisGraphDataCacheDto(
    @PrimaryKey val type: String,
    val values: List<AnalysisGraphPointCacheDto>,
)