package ru.pyroman.medanalytica.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ru.pyroman.medanalytica.activity.di.MainActivityComponent
import ru.pyroman.medanalytica.feature.view.AnalysisGraphScreenView
import ru.pyroman.medanalytica.ui.theme.MedAnalyticaTheme
import ru.pyroman.medanalytica.application.MedanalyticaApplication
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var analysisGraphViewModelFactory: AnalysisGraphViewModelFactory

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
                   AnalysisGraphScreenView(
                       viewModelFactory = analysisGraphViewModelFactory,
                   )
                }
            }
        }
    }
}