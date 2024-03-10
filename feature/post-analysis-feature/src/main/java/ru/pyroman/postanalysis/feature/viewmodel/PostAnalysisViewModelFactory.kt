package ru.pyroman.postanalysis.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.pyroman.medanalytica.domain.postanalysis.repository.PostAnalysisRepository
import javax.inject.Inject

class PostAnalysisViewModelFactory @Inject constructor(
    private val postAnalysisRepository: PostAnalysisRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostAnalysisViewModel(
            postAnalysisRepository = postAnalysisRepository,
        ) as T
    }
}