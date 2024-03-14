package ru.pyroman.medanalytica.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.pyroman.medanalytica.domain.login.repository.LoginRepository
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(
    private val loginRepository: LoginRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(
            loginRepository = loginRepository,
        ) as T
    }
}