package ru.pyroman.medanalytica.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphFormatter
import ru.pyroman.medanalytica.feature.state.AnalysisGraphState

internal class AnalysisGraphViewModel internal constructor(
    private val analysisGraphFormatter: AnalysisGraphFormatter,
    private val analysisGraphRepository: AnalysisGraphRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<AnalysisGraphState>(AnalysisGraphState.Loading)
    val viewState = _viewState.asStateFlow()

    fun getGraphList() = viewModelScope.launch {
        _viewState.value = AnalysisGraphState.Loading
        val graphList = withContext(Dispatchers.IO) {
             analysisGraphRepository.getGraphList()
        }
        val graphListVo = analysisGraphFormatter.format(graphList)
        _viewState.value = AnalysisGraphState.Success(
            graphListVo = graphListVo
        )
    }
}