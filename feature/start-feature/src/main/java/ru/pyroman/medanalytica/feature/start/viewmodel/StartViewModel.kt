package ru.pyroman.medanalytica.feature.start.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.start.repository.StartRepository
import ru.pyroman.medanalytica.feature.start.state.StartState
import javax.inject.Inject

class StartViewModel @Inject internal constructor(
    private val startRepository: StartRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<StartState>(StartState.Idle)
    val viewState = _viewState.asStateFlow()

    fun checkIsLoggedIn(
        onLoggedIn: () -> Unit,
    ) = viewModelScope.launch {
        _viewState.emit(StartState.Loading)

        val newState = withContext(Dispatchers.IO) {
            val isLoggedIn = startRepository.isLoggedIn()

            if (isLoggedIn) {
                withContext(Dispatchers.Main) {
                    onLoggedIn()
                }
            }

            StartState.Idle
        }

        _viewState.emit(newState)
    }
}