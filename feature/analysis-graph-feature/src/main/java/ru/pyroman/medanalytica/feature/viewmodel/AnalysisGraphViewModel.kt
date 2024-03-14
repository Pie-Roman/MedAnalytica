package ru.pyroman.medanalytica.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.analysisgraph.model.AnalysisGraphListData
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphFormatter
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphWarningFormatter
import ru.pyroman.medanalytica.feature.state.AnalysisGraphState
import javax.inject.Inject

class AnalysisGraphViewModel @Inject internal constructor(
    private val analysisGraphFormatter: AnalysisGraphFormatter,
    private val analysisGraphWarningFormatter: AnalysisGraphWarningFormatter,
    private val analysisGraphRepository: AnalysisGraphRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<AnalysisGraphState>(AnalysisGraphState.Idle)
    val viewState = _viewState.asStateFlow()

    fun reset() = viewModelScope.launch {
        _viewState.emit(AnalysisGraphState.Idle)
    }

    fun onSearchInput(searchInput: String) = viewModelScope.launch {
        submitNewGraphListData {
            val searchInputFormatted = searchInput
                .trim()
            analysisGraphRepository.searchGraphs(searchInputFormatted)
        }
    }

    fun onRefresh() = viewModelScope.launch {
        if (_viewState.value == AnalysisGraphState.Loading) {
            return@launch
        }

        submitNewGraphListData {
            analysisGraphRepository.fetchGraphList()
        }
    }

    fun onLogoutClick(
        onComplete: () -> Unit,
    ) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            analysisGraphRepository.clearCache()
        }
        onComplete()
    }

    private suspend fun submitNewGraphListData(
        extractFunc: suspend () -> AnalysisGraphListData,
    ) {
        _viewState.emit(AnalysisGraphState.Loading)

        val newState = try {
            val graphListData = withContext(Dispatchers.IO) {
                extractFunc()
            }
            val graphListVo = analysisGraphFormatter.format(graphListData.graphs)
            val warningVo = graphListData.warning?.let {
                analysisGraphWarningFormatter.format(it)
            }
            AnalysisGraphState.Success(
                graphListVo = graphListVo,
                warningVo = warningVo,
            )
        } catch (error: Throwable) {
            AnalysisGraphState.Error
        }

        _viewState.emit(newState)
    }
}