package ru.pyroman.medanalytica.feature.di

import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphFormatter

@Module
interface AnalysisGraphFeatureModule {

    companion object {

        @Provides
        internal fun provideAnalysisGraphFormatter(): AnalysisGraphFormatter {
            return AnalysisGraphFormatter()
        }
    }
}