package ru.pyroman.medanalytica.data.analysisgraph.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheDataSource
import ru.pyroman.medanalytica.data.analysisgraph.cache.AnalysisGraphCacheMapper
import ru.pyroman.medanalytica.data.analysisgraph.cache.database.AnalysisGraphCacheTypeConverter
import ru.pyroman.medanalytica.data.analysisgraph.cache.database.AnalysisGraphDao
import ru.pyroman.medanalytica.data.analysisgraph.cache.database.AnalysisGraphDatabase
import ru.pyroman.medanalytica.data.analysisgraph.network.AnalysisGraphNetworkDataSource
import ru.pyroman.medanalytica.data.analysisgraph.network.AnalysisGraphNetworkMapper
import ru.pyroman.medanalytica.data.analysisgraph.network.api.AnalysisGraphNetworkApi
import ru.pyroman.medanalytica.data.analysisgraph.repository.AnalysisGraphRepositoryImpl
import ru.pyroman.medanalytica.domain.analysisgraph.repository.AnalysisGraphRepository

@Module
interface AnalysisGraphDataModule {

    @Binds
    fun bindAnalysisGraphRepository(
        impl: AnalysisGraphRepositoryImpl,
    ): AnalysisGraphRepository

    companion object {

        @Provides
        internal fun provideAnalysisGraphNetworkApi(): AnalysisGraphNetworkApi {
            return AnalysisGraphNetworkApi.build()
        }

        @Provides
        internal fun provideAnalysisGraphNetworkMapper(): AnalysisGraphNetworkMapper {
            return AnalysisGraphNetworkMapper()
        }

        @Provides
        internal fun provideAnalysisGraphNetworkDataSource(
            api: AnalysisGraphNetworkApi
        ): AnalysisGraphNetworkDataSource {
            return AnalysisGraphNetworkDataSource()
        }

        @Provides
        internal fun provideAnalysisGraphCacheTypeConverter(): AnalysisGraphCacheTypeConverter {
            return AnalysisGraphCacheTypeConverter()
        }

        @Provides
        internal fun provideAnalysisGraphDatabase(
            application: Application,
            typeConverter: AnalysisGraphCacheTypeConverter,
        ): AnalysisGraphDatabase {
            return AnalysisGraphDatabase.build(
                application = application,
                typeConverter = typeConverter,
            )
        }

        @Provides
        internal fun provideAnalysisGraphDao(
            database: AnalysisGraphDatabase,
        ): AnalysisGraphDao {
            return database.dao()
        }

        @Provides
        internal fun provideAnalysisGraphCacheMapper(): AnalysisGraphCacheMapper {
            return AnalysisGraphCacheMapper()
        }

        @Provides
        internal fun provideAnalysisGraphCacheDataSource(
            dao: AnalysisGraphDao,
        ): AnalysisGraphCacheDataSource {
            return AnalysisGraphCacheDataSource(
                dao = dao,
            )
        }

        @Provides
        internal fun provideAnalysisGraphRepositoryImpl(
            networkDataSource: AnalysisGraphNetworkDataSource,
            networkMapper: AnalysisGraphNetworkMapper,
            cacheDataSource: AnalysisGraphCacheDataSource,
            cacheMapper: AnalysisGraphCacheMapper,
        ): AnalysisGraphRepositoryImpl {
            return AnalysisGraphRepositoryImpl(
                networkDataSource = networkDataSource,
                networkMapper = networkMapper,
                cacheDataSource = cacheDataSource,
                cacheMapper = cacheMapper,
            )
        }
    }
}