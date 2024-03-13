package ru.pyroman.medanalytica.common.navigation.api

sealed class Screen(
    val route: String,
) {

    data object Start : Screen(route = "start")
    data object AnalysisGraph : Screen(route = "analysis_graph")

    data object PostAnalysis : Screen(route = "post_analysis")

    data object Register : Screen(route = "register")

    data object Auth : Screen(route = "auth")
}