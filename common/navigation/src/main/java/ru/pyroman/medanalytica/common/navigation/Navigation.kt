package ru.pyroman.medanalytica.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.login.view.LoginScreenView
import ru.pyroman.medanalytica.feature.register.view.RegisterScreenView
import ru.pyroman.medanalytica.feature.view.AnalysisGraphScreenView
import ru.pyroman.medanalytica.postanalysis.feature.view.PostAnalysisScreenView

@Composable
fun Navigation(
    viewModelsFactory: ViewModelsFactory,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Register.route,
    ) {
        composable(route = Screen.Start.route) {

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