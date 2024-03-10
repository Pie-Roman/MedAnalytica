package ru.pyroman.medanalytica.data.uid.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.uid.cache.UidCacheDataSource
import ru.pyroman.medanalytica.data.uid.repository.UidRepositoryImpl
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository

@Module
interface UidDataModule {

    @Binds
    fun bindUidRepository(impl: UidRepositoryImpl): UidRepository

    companion object {
        @Provides
        internal fun provideUidCacheDataStore(
            applicationContext: Context,
        ): UidCacheDataSource {
            return UidCacheDataSource(
                applicationContext = applicationContext,
            )
        }

        @Provides
        internal fun provideUidRepositoryImpl(
            cacheDataSource: UidCacheDataSource,
        ): UidRepositoryImpl {
            return UidRepositoryImpl(
                cacheDataSource = cacheDataSource,
            )
        }
    }

}