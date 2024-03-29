package ru.pyroman.medanalytica.feature.start.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.start.state.StartState
import ru.pyroman.medanalytica.feature.start.view.start.StartView
import ru.pyroman.medanalytica.feature.start.viewmodel.StartViewModel

@Composable
fun StartScreenView(
    viewModel: StartViewModel,
    navController: NavController,
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.checkIsLoggedIn(
            onLoggedIn = {
                navController.navigate(Screen.AnalysisGraph.route)
            },
        )
    }

    when (state) {
        is StartState.Idle -> {
            StartView(
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                },
                onRegisterClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        is StartState.Loading -> {

        }
        is StartState.Error -> {

        }
    }
}