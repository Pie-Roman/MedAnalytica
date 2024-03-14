package ru.pyroman.medanalytica.common.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.login.view.LoginScreenView
import ru.pyroman.medanalytica.feature.register.view.RegisterScreenView
import ru.pyroman.medanalytica.feature.start.view.StartScreenView
import ru.pyroman.medanalytica.feature.view.AnalysisGraphScreenView
import ru.pyroman.medanalytica.postanalysis.feature.view.PostAnalysisScreenView

@Composable
fun Navigation(
    viewModelsFactory: ViewModelsFactory,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route,
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
            StartScreenView(
                viewModelFactory = viewModelsFactory.startViewModelFactory,
                navController = navController,
            )
        }
        composable(route = Screen.Login.route) {
            LoginScreenView(
                viewModelFactory = viewModelsFactory.loginViewModelFactory,
                navController = navController,
            )
        }
        composable(route = Screen.Register.route) {
            RegisterScreenView(
                viewModelFactory = viewModelsFactory.registerViewModelFactory,
                navController = navController,
            )
        }
        composable(route = Screen.AnalysisGraph.route) {
            AnalysisGraphScreenView(
                viewModelFactory = viewModelsFactory.analysisGraphViewModelFactory,
                navController = navController,
            )
        }
        composable(route = Screen.PostAnalysis.route) {
            PostAnalysisScreenView(
                viewModelFactory = viewModelsFactory.postAnalysisViewModelFactory,
                navController = navController,
            )
        }
    }
}