package ru.pyroman.medanalytica.common.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.login.view.LoginScreenView
import ru.pyroman.medanalytica.feature.profile.view.ProfileScreenView
import ru.pyroman.medanalytica.feature.register.view.RegisterScreenView
import ru.pyroman.medanalytica.feature.start.view.StartScreenView
import ru.pyroman.medanalytica.feature.view.AnalysisGraphScreenView
import ru.pyroman.medanalytica.postanalysis.feature.view.PostAnalysisScreenView

@Composable
fun Navigation(
    viewModelsRegistry: ViewModelsRegistry,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route,
        enterTransition = { slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Start,
            animationSpec = tween(300)
        ) },
        exitTransition = { slideOutOfContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Start,
            animationSpec = tween(300)
        ) },
    ) {
        composable(route = Screen.Start.route) {
            BackHandler {}

            StartScreenView(
                viewModel = viewModelsRegistry.startViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.Login.route) {
            BackHandler {}

            LoginScreenView(
                viewModel = viewModelsRegistry.loginViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.Register.route) {
            BackHandler {}

            RegisterScreenView(
                viewModel = viewModelsRegistry.registerViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.AnalysisGraph.route) {
            BackHandler {}

            AnalysisGraphScreenView(
                viewModel = viewModelsRegistry.analysisGraphViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.PostAnalysis.route) {
            BackHandler {}

            PostAnalysisScreenView(
                viewModel = viewModelsRegistry.postAnalysisViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.Profile.route) {
            BackHandler {}

            ProfileScreenView(
                viewModel = viewModelsRegistry.profileViewModel,
                navController = navController,
            )
        }
    }
}