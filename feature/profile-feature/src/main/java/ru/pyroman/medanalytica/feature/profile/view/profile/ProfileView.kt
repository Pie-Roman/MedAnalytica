package ru.pyroman.medanalytica.feature.profile.view.profile

import androidx.compose.runtime.Composable
import ru.pyroman.medanalytica.feature.profile.state.ProfileState
import ru.pyroman.medanalytica.feature.profile.vo.ProfileDataVo

@Composable
fun ProfileView(
    state: ProfileState,
    onIdle: () -> Unit,
    onProfileInput: (ProfileDataVo) -> Unit,
    onBack: () -> Unit,
) {
    when (state) {

        is ProfileState.Idle ->
            onIdle()

        is ProfileState.Loading ->
            ProfileLoadingView(
                onBackClick = onBack,
            )

        is ProfileState.Success ->
            ProfileSuccessView(
                vo = state.vo,
                onProfileInput = onProfileInput,
                onBackClick = onBack,
            )

        is ProfileState.Error ->
            ProfileErrorView(
                onBackClick = onBack,
            )
    }
}