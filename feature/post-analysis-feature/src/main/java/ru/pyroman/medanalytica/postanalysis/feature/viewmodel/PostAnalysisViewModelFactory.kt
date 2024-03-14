package ru.pyroman.medanalytica.postanalysis.feature.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.pyroman.medanalytica.domain.postanalysis.repository.PostAnalysisRepository
import javax.inject.Inject

class PostAnalysisViewModelFactory @Inject constructor(
    private val application: Application,
    private val postAnalysisRepository: PostAnalysisRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostAnalysisViewModel(
            application = application,
            postAnalysisRepository = postAnalysisRepository,
        ) as T
    }
}