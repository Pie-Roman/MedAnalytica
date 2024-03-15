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

    fun onLogin(
        loginData: LoginData,
        onSuccess: () -> Unit,
    ) = viewModelScope.launch {
        if (_viewState.value == LoginState.Loading) {
            return@launch
        }

        _viewState.emit(LoginState.Loading)

        val newState = withContext(Dispatchers.IO) {
            try {
                when (val result = loginRepository.login(loginData)) {
                    is LoginResult.Success -> {
                        withContext(Dispatchers.Main) {
                            onSuccess()
                        }
                        LoginState.Idle
                    }
                    is LoginResult.Failure -> LoginState.Failure(result.message)
                }
            } catch (error: Throwable) {
                LoginState.Error
            }
        }

        _viewState.emit(newState)
    }
}