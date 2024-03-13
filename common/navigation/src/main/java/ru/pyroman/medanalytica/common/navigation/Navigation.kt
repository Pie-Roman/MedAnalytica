package ru.pyroman.medanalytica.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.view.AnalysisGraphScreenView
import ru.pyroman.postanalysis.feature.view.PostAnalysisScreenView

@Composable
fun Navigation(
    viewModelsFactory: ViewModelsFactory,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.AnalysisGraph.route,
    ) {
        composable(route = Screen.Start.route) {

        }
        composable(route = Screen.Auth.route) {

        }
        composable(route = Screen.Register.route) {

        }
        composable(route = Screen.AnalysisGraph.route) {
            AnalysisGraphScreenView(
                viewModelFactory = viewModelsFactory.analysisGraphViewModelFactory,
            )
        }
        composable(route = Screen.PostAnalysis.route) {
            PostAnalysisScreenView(
                viewModelFactory = viewModelsFactory.postAnalysisViewModelFactory,
            )
        }
    }
}