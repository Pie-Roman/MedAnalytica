package ru.pyroman.medanalytica.feature.di

import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphFormatter
import ru.pyroman.medanalytica.feature.formatter.AnalysisGraphWarningFormatter

@Module
interface AnalysisGraphFeatureModule {

    companion object {

        @Provides
        internal fun provideAnalysisGraphFormatter(): AnalysisGraphFormatter {
            return AnalysisGraphFormatter()
        }

        @Provides
        internal fun provideAnalysisGraphWarningFormatter(): AnalysisGraphWarningFormatter {
            return AnalysisGraphWarningFormatter()
        }
    }
}