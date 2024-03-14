package ru.pyroman.medanalytica.common.navigation

import ru.pyroman.medanalytica.feature.login.viewmodel.LoginViewModelFactory
import ru.pyroman.medanalytica.feature.register.viewmodel.RegisterViewModelFactory
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModelFactory
import ru.pyroman.medanalytica.postanalysis.feature.viewmodel.PostAnalysisViewModelFactory

class ViewModelsFactory(
    val analysisGraphViewModelFactory: AnalysisGraphViewModelFactory,
    val postAnalysisViewModelFactory: PostAnalysisViewModelFactory,
    val loginViewModelFactory: LoginViewModelFactory,
    val registerViewModelFactory: RegisterViewModelFactory,
)