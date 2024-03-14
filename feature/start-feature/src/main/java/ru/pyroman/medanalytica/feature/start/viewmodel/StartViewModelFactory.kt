package ru.pyroman.medanalytica.feature.start.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.pyroman.medanalytica.domain.start.repository.StartRepository
import javax.inject.Inject

class StartViewModelFactory @Inject constructor(
    private val startRepository: StartRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StartViewModel(
            startRepository = startRepository,
        ) as T
    }
}