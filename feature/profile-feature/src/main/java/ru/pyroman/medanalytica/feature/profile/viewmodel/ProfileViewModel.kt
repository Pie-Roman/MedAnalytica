package ru.pyroman.medanalytica.feature.profile.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.pyroman.medanalytica.domain.profile.repository.ProfileRepository
import ru.pyroman.medanalytica.feature.profile.state.ProfileState
import javax.inject.Inject

class ProfileViewModel @Inject internal constructor(
    private val profileRepository: ProfileRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<ProfileState>(ProfileState.Idle)
    val viewState = _viewState.asStateFlow()
}