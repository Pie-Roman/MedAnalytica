package ru.pyroman.postanalysis.feature.viewmodel

import android.net.Uri
import androidx.core.net.toFile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.postanalysis.model.PostAnalysisData
import ru.pyroman.medanalytica.domain.postanalysis.repository.PostAnalysisRepository
import ru.pyroman.postanalysis.feature.state.PostAnalysisState

internal class PostAnalysisViewModel(
    private val postAnalysisRepository: PostAnalysisRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<PostAnalysisState>(PostAnalysisState.Idle)
    val viewState = _viewState.asStateFlow()

    fun onFileInput(uri: Uri) = viewModelScope.launch {
        if (_viewState.value == PostAnalysisState.Loading) {
            return@launch
        }

        _viewState.emit(PostAnalysisState.Loading)

        val newState = withContext(Dispatchers.IO) {
            try {
                val postAnalysisData = PostAnalysisData(
                    file = uri.toFile(),
                )
                val result = postAnalysisRepository.postAnalysis(postAnalysisData)
                PostAnalysisState.Success(
                    result = result,
                )
            } catch (error: Throwable) {
                PostAnalysisState.Error
            }
        }

        _viewState.emit(newState)
    }
}