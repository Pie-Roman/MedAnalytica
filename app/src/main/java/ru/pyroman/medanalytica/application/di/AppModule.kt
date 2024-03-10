package ru.pyroman.medanalytica.application.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
interface AppModule {

    companion object {

        @Provides
        @ApplicationScope
        fun applicationContext(
            application: Application,
        ): Context {
            return application.applicationContext
        }
    }
}