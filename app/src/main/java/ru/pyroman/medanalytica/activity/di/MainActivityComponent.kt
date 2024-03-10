package ru.pyroman.medanalytica.activity.di

import dagger.Subcomponent
import ru.pyroman.medanalytica.activity.MainActivity
import ru.pyroman.medanalytica.data.analysisgraph.di.AnalysisGraphDataModule
import ru.pyroman.medanalytica.feature.di.AnalysisGraphFeatureModule

@Subcomponent(modules = [
    // Feature modules
    AnalysisGraphFeatureModule::class,

    // Data modules
    AnalysisGraphDataModule::class
])
@MainActivityScope
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(instance: MainActivity)
}