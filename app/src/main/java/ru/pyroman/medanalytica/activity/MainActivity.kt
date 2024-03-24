package ru.pyroman.medanalytica.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ru.pyroman.medanalytica.activity.di.MainActivityComponent
import ru.pyroman.medanalytica.application.MedanalyticaApplication
import ru.pyroman.medanalytica.common.navigation.Navigation
import ru.pyroman.medanalytica.common.navigation.ViewModelsRegistry
import ru.pyroman.medanalytica.feature.login.viewmodel.LoginViewModel
import ru.pyroman.medanalytica.feature.profile.viewmodel.ProfileViewModel
import ru.pyroman.medanalytica.feature.register.viewmodel.RegisterViewModel
import ru.pyroman.medanalytica.feature.start.viewmodel.StartViewModel
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModel
import ru.pyroman.medanalytica.postanalysis.feature.viewmodel.PostAnalysisViewModel
import ru.pyroman.medanalytica.ui.theme.MedAnalyticaTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var analysisGraphViewModel: AnalysisGraphViewModel

    @Inject
    lateinit var postAnalysisViewModel: PostAnalysisViewModel

    @Inject
    lateinit var loginViewModel: LoginViewModel

    @Inject
    lateinit var registerViewModel: RegisterViewModel

    @Inject
    lateinit var startViewModel: StartViewModel

    @Inject
    lateinit var profileViewModel: ProfileViewModel

    private lateinit var activityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = (applicationContext as MedanalyticaApplication)
            .appComponent
            .mainActivityComponentFactory()
            .create()
        activityComponent.inject(this)

        super.onCreate(savedInstanceState)

        setContent {
            MedAnalyticaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Navigation(
                       viewModelsRegistry = ViewModelsRegistry(
                           analysisGraphViewModel = analysisGraphViewModel,
                           postAnalysisViewModel = postAnalysisViewModel,
                           loginViewModel = loginViewModel,
                           registerViewModel= registerViewModel,
                           startViewModel = startViewModel,
                           profileViewModel = profileViewModel,
                       )
                   )
                }
            }
        }
    }
}