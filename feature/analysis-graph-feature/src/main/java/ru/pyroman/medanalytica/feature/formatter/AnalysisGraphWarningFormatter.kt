package ru.pyroman.medanalytica.feature.formatter

import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphListWarning
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphWarningVo

class AnalysisGraphWarningFormatter {

    fun format(warning: AnalysisGraphListWarning): AnalysisGraphWarningVo {
        return when (warning) {
            AnalysisGraphListWarning.NETWORK_ERROR ->
                formatNetworkErrorWarning()
        }
    }

    private fun formatNetworkErrorWarning(): AnalysisGraphWarningVo {
        return AnalysisGraphWarningVo(
            warningText = "Ошибка соединения с сервером"
        )
    }
}