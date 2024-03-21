package ru.pyroman.medanalytica.feature.profile.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.medanalytica.domain.profile.repository.ProfileRepository
import ru.pyroman.medanalytica.feature.profile.formatter.ProfileFormatter
import ru.pyroman.medanalytica.feature.profile.state.ProfileState
import ru.pyroman.medanalytica.feature.profile.vo.ProfileDataVo
import javax.inject.Inject

class ProfileViewModel @Inject internal constructor(
    private val profileRepository: ProfileRepository,
    private val profileFormatter: ProfileFormatter,
) : ViewModel() {

    private val _viewState = MutableStateFlow<ProfileState>(ProfileState.Idle)
    val viewState = _viewState.asStateFlow()

    fun onIdle() = viewModelScope.launch {
        if (_viewState.value == ProfileState.Loading) {
            return@launch
        }

        _viewState.emit(ProfileState.Loading)

        val newState = withContext(Dispatchers.IO) {
            try {
                val profileData = profileRepository.getProfileData()
                val vo = profileFormatter.format(profileData)
                ProfileState.Success(vo)
            } catch (error: Throwable) {
                Log.e("err", error.stackTraceToString())
                ProfileState.Error
            }
        }

        _viewState.emit(newState)
    }

    fun onProfileInput(
        profileDataVo: ProfileDataVo,
        onSuccess: () -> Unit,
    ) = viewModelScope.launch {
        if (_viewState.value == ProfileState.Loading) {
            return@launch
        }

        _viewState.emit(ProfileState.Loading)

        val newState = withContext(Dispatchers.IO) {
            try {
                val profileData = profileFormatter.format(profileDataVo)
                profileRepository.patchProfileData(profileData)
                withContext(Dispatchers.Main) {
                    onSuccess()
                }
                ProfileState.Idle
            } catch (error: Throwable) {
                ProfileState.Error
            }
        }

        _viewState.emit(newState)
    }
}