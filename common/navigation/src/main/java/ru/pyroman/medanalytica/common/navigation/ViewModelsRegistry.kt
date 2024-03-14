package ru.pyroman.medanalytica.common.navigation

import ru.pyroman.medanalytica.feature.login.viewmodel.LoginViewModel
import ru.pyroman.medanalytica.feature.register.viewmodel.RegisterViewModel
import ru.pyroman.medanalytica.feature.start.viewmodel.StartViewModel
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModel
import ru.pyroman.medanalytica.postanalysis.feature.viewmodel.PostAnalysisViewModel

class ViewModelsRegistry(
    val analysisGraphViewModel: AnalysisGraphViewModel,
    val postAnalysisViewModel: PostAnalysisViewModel,
    val loginViewModel: LoginViewModel,
    val registerViewModel: RegisterViewModel,
    val startViewModel: StartViewModel,
)