package ru.pyroman.medanalytica.feature.vo

import com.patrykandpatrick.vico.core.entry.ChartEntry

class AnalysisGraphPointVo(
    val creationDateTime: String,
    index: Float,
    value: Float,
): ChartEntry {

    override val x = index

    override val y = value

    override fun withY(y: Float) = AnalysisGraphPointVo(
        creationDateTime = creationDateTime,
        index = x,
        value = y,
    )
}