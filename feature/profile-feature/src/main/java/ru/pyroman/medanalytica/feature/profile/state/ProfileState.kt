package ru.pyroman.medanalytica.feature.profile.state

import ru.pyroman.medanalytica.feature.profile.vo.ProfileDataVo

sealed class ProfileState {

    data object Idle : ProfileState()

    data object Loading : ProfileState()

    data class Success(val vo: ProfileDataVo) : ProfileState()

    data object Error : ProfileState()
}