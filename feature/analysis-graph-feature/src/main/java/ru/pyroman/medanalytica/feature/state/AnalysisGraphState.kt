package ru.pyroman.medanalytica.feature.state

import ru.pyroman.medanalytica.feature.vo.AnalysisGraphListVo

sealed class AnalysisGraphState {

    data object Loading : AnalysisGraphState()

    data class Success(
        val graphListVo: AnalysisGraphListVo,
    ) : AnalysisGraphState()

    data object Error : AnalysisGraphState()
}

