package ru.pyroman.medanalytica.data.postanalysis.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.postanalysis.network.PostAnalysisNetworkDataSource
import ru.pyroman.medanalytica.data.postanalysis.network.PostAnalysisNetworkMapper
import ru.pyroman.medanalytica.data.postanalysis.network.api.PostAnalysisNetworkApi
import ru.pyroman.medanalytica.data.postanalysis.repository.PostAnalysisRepositoryImpl
import ru.pyroman.medanalytica.domain.postanalysis.repository.PostAnalysisRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository

@Module
interface PostAnalysisDataModule {

    @Binds
    fun bindPostAnalysisRepository(
        impl: PostAnalysisRepositoryImpl,
    ): PostAnalysisRepository

    companion object {

        @Provides
        internal fun providePostAnalysisNetworkApi(): PostAnalysisNetworkApi {
            return PostAnalysisNetworkApi.build()
        }

        @Provides
        internal fun providePostAnalysisNetworkMapper(): PostAnalysisNetworkMapper {
            return PostAnalysisNetworkMapper()
        }

        @Provides
        internal fun providePostAnalysisNetworkDataSource(
            api: PostAnalysisNetworkApi
        ): PostAnalysisNetworkDataSource {
            return PostAnalysisNetworkDataSource(
                api = api,
            )
        }

        @Provides
        internal fun providePostAnalysisRepositoryImpl(
            uidRepository: UidRepository,
            networkDataSource: PostAnalysisNetworkDataSource,
            networkMapper: PostAnalysisNetworkMapper,
        ): PostAnalysisRepositoryImpl {
            return PostAnalysisRepositoryImpl(
                uidRepository = uidRepository,
                networkDataSource = networkDataSource,
                networkMapper = networkMapper,
            )
        }
    }
}