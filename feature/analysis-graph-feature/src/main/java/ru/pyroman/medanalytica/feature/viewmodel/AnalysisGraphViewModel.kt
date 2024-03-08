package ru.pyroman.medanalytica.feature.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.pyroman.medanalytica.feature.state.AnalysisGraphState

class AnalysisGraphViewModel(application: Application) : AndroidViewModel(application) {

    private val _viewState = MutableStateFlow<AnalysisGraphState>(AnalysisGraphState.Loading)
    val viewState = _viewState.asStateFlow()




}