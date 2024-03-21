package ru.pyroman.medanalytica.feature.profile.view.profile

import androidx.compose.runtime.Composable
import ru.pyroman.medanalytica.feature.profile.state.ProfileState
import ru.pyroman.medanalytica.feature.profile.vo.ProfileDataVo

@Composable
fun ProfileView(
    state: ProfileState,
    onIdle: () -> Unit,
    onProfileInput: (ProfileDataVo) -> Unit,
) {
    when (state) {

        is ProfileState.Idle ->
            onIdle()

        is ProfileState.Loading ->
            Unit

        is ProfileState.Success ->
            ProfileSuccessView(
                vo = state.vo,
                onProfileInput = onProfileInput,
            )

        is ProfileState.Error ->
            Unit
    }
}