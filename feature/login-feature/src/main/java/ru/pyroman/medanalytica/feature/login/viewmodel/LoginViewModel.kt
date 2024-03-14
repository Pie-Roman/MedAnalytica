package ru.pyroman.medanalytica.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.login.model.LoginData
import ru.pyroman.medanalytica.domain.login.model.LoginResult
import ru.pyroman.medanalytica.domain.login.repository.LoginRepository
import ru.pyroman.medanalytica.feature.login.state.LoginState
import javax.inject.Inject

class LoginViewModel @Inject internal constructor(
    private val loginRepository: LoginRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<LoginState>(LoginState.Idle)
    val viewState = _viewState.asStateFlow()

    fun onLogin(loginData: LoginData) = viewModelScope.launch {
        if (_viewState.value == LoginState.Loading) {
            return@launch
        }

        _viewState.emit(LoginState.Loading)

        val newState = withContext(Dispatchers.IO) {
            try {
                val result = loginRepository.login(loginData)
                when (result) {
                    LoginResult.SUCCESS -> LoginState.Success
                    LoginResult.FAILURE -> LoginState.Failure
                }
            } catch (error: Throwable) {
                LoginState.Error
            }
        }

        _viewState.emit(newState)
    }
}