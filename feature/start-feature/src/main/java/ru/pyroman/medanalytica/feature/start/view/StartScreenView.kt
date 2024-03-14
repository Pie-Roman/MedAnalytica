package ru.pyroman.medanalytica.feature.start.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.start.state.StartState
import ru.pyroman.medanalytica.feature.start.view.start.StartView
import ru.pyroman.medanalytica.feature.start.viewmodel.StartViewModel
import ru.pyroman.medanalytica.feature.start.viewmodel.StartViewModelFactory

@Composable
fun StartScreenView(
    viewModelFactory: StartViewModelFactory,
    navController: NavController,
) {

    val viewModel: StartViewModel = viewModel(
        factory = viewModelFactory,
    )
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    when (state) {
        is StartState.Idle -> {
            viewModel.checkIsLoggedIn()
        }
        is StartState.Loading -> {

        }
        is StartState.NotLoggedIn -> {
            StartView(
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                },
                onRegisterClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        is StartState.ProceedNext -> {
            navController.navigate(Screen.AnalysisGraph.route)
        }
        is StartState.Error -> {

        }
    }
}