package ru.pyroman.medanalytica.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphFormatter
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphWarningFormatter
import javax.inject.Inject

class AnalysisGraphViewModelFactory @Inject internal constructor(
    private val analysisGraphFormatter: AnalysisGraphFormatter,
    private val analysisGraphWarningFormatter: AnalysisGraphWarningFormatter,
    private val analysisGraphRepository: AnalysisGraphRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AnalysisGraphViewModel(
            analysisGraphFormatter = analysisGraphFormatter,
            analysisGraphWarningFormatter = analysisGraphWarningFormatter,
            analysisGraphRepository = analysisGraphRepository,
        ) as T
    }
}