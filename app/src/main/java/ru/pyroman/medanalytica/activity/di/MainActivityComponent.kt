package ru.pyroman.medanalytica.activity.di

import dagger.Subcomponent
import ru.pyroman.medanalytica.activity.MainActivity
import ru.pyroman.medanalytica.data.analysisgraph.di.AnalysisGraphDataModule
import ru.pyroman.medanalytica.data.postanalysis.di.PostAnalysisDataModule
import ru.pyroman.medanalytica.data.token.di.TokenDataModule
import ru.pyroman.medanalytica.data.uid.di.UidDataModule
import ru.pyroman.medanalytica.feature.di.AnalysisGraphFeatureModule

@Subcomponent(modules = [
    // Feature modules
    AnalysisGraphFeatureModule::class,

    // Data modules
    UidDataModule::class,
    TokenDataModule::class,
    AnalysisGraphDataModule::class,
    PostAnalysisDataModule::class,
])
@MainActivityScope
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(instance: MainActivity)
}