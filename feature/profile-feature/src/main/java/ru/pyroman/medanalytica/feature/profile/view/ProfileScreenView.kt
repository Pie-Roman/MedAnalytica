package ru.pyroman.medanalytica.feature.profile.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ru.pyroman.medanalytica.feature.profile.view.profile.ProfileView
import ru.pyroman.medanalytica.feature.profile.viewmodel.ProfileViewModel

@Composable
fun ProfileScreenView(
    viewModel: ProfileViewModel,
    navController: NavController,
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    ProfileView(
        state = state,
        onIdle = {
            viewModel.onIdle()
        },
        onProfileInput = { profileDataVo ->
            viewModel.onProfileInput(
                profileDataVo = profileDataVo,
                onSuccess = {
                    navController.navigateUp()
                }
            )
        },
        onBack = {
            navController.navigateUp()
        },
        onRetry = {
            viewModel.onRetry()
        }
    )
}