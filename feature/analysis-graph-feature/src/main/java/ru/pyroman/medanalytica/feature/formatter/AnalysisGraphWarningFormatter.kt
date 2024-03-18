package ru.pyroman.medanalytica.feature.formatter

import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphListWarning
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphWarningVo

class AnalysisGraphWarningFormatter {

    fun format(warning: AnalysisGraphListWarning): AnalysisGraphWarningVo {
        return when (warning) {
            AnalysisGraphListWarning.NETWORK_ERROR ->
                formatNetworkErrorWarning()
            AnalysisGraphListWarning.EMPTY ->
                formatEmptyWarning()
            AnalysisGraphListWarning.EMPTY_BY_SEARCH ->
                formatEmptyBySearchWarning()
        }
    }

    private fun formatNetworkErrorWarning(): AnalysisGraphWarningVo {
        return AnalysisGraphWarningVo(
            warningText = "Ошибка соединения с сервером. Показаны последние актуальные графики анализов"
        )
    }

    private fun formatEmptyWarning(): AnalysisGraphWarningVo {
        return AnalysisGraphWarningVo(
            warningText = "Пока нет графиков! Вы можете добавить анализ через кнопку \"+\""
        )
    }

    private fun formatEmptyBySearchWarning(): AnalysisGraphWarningVo {
        return AnalysisGraphWarningVo(
            warningText = "Нет найденных анализов"
        )
    }
}