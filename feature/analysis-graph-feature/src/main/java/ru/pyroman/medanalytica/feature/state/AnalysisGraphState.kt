package ru.pyroman.medanalytica.feature.state

import ru.pyroman.medanalytica.feature.vo.AnalysisGraphListVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphWarningVo

sealed class AnalysisGraphState {

    data object Idle : AnalysisGraphState()

    data object Loading : AnalysisGraphState()

    data class Success(
        val graphListVo: AnalysisGraphListVo,
        val warningVo: AnalysisGraphWarningVo?,
    ) : AnalysisGraphState()

    data object Error : AnalysisGraphState()
}

