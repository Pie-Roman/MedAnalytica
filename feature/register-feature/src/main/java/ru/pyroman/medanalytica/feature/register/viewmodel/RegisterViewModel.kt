package ru.pyroman.medanalytica.feature.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.register.model.RegisterData
import ru.pyroman.medanalytica.domain.register.model.RegisterResult
import ru.pyroman.medanalytica.domain.register.repository.RegisterRepository
import ru.pyroman.medanalytica.feature.register.state.RegisterState
import javax.inject.Inject

class RegisterViewModel @Inject internal constructor(
    private val registerRepository: RegisterRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<RegisterState>(RegisterState.Idle)
    val viewState = _viewState.asStateFlow()

    fun reset() = viewModelScope.launch {
        _viewState.emit(RegisterState.Idle)
    }

    fun onRegister(registerData: RegisterData) = viewModelScope.launch {
        if (_viewState.value == RegisterState.Loading) {
            return@launch
        }

        _viewState.emit(RegisterState.Loading)

        val newState = withContext(Dispatchers.IO) {
            try {
                val result = registerRepository.register(registerData)
                when (result) {
                    RegisterResult.SUCCESS -> RegisterState.Success
                    RegisterResult.FAILURE -> RegisterState.Failure
                }
            } catch (error: Throwable) {
                RegisterState.Error
            }
        }

        _viewState.emit(newState)
    }
}