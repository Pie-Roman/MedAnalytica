package ru.pyroman.medanalytica.application

import android.app.Application
import ru.pyroman.medanalytica.application.di.AppComponent
import ru.pyroman.medanalytica.application.di.DaggerAppComponent

class MedanalyticaApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        appComponent = DaggerAppComponent
            .factory()
            .create(
                application = this
            )
        super.onCreate()
    }
}