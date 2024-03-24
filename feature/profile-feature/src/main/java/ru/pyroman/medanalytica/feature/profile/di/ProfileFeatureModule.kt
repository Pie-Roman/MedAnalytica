package ru.pyroman.medanalytica.feature.profile.di

import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.feature.profile.formatter.ProfileFormatter

@Module
interface ProfileFeatureModule {

    companion object {

        @Provides
        fun provideProfileFormatter(): ProfileFormatter {
            return ProfileFormatter()
        }
    }
}