package ru.pyroman.medanalytica.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphFormatter
import javax.inject.Inject

class AnalysisGraphViewModelFactory @Inject internal constructor(
    private val analysisGraphFormatter: AnalysisGraphFormatter,
    private val analysisGraphRepository: AnalysisGraphRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AnalysisGraphViewModel(
            analysisGraphFormatter = analysisGraphFormatter,
            analysisGraphRepository = analysisGraphRepository,
        ) as T
    }
}