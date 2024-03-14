package ru.pyroman.medanalytica.feature.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.pyroman.medanalytica.domain.register.repository.RegisterRepository
import javax.inject.Inject

class RegisterViewModelFactory @Inject constructor(
    private val registerRepository: RegisterRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegisterViewModel(
            registerRepository = registerRepository,
        ) as T
    }
}