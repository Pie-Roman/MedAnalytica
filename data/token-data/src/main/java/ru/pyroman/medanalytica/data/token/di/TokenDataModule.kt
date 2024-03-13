package ru.pyroman.medanalytica.data.token.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.token.cache.TokenCacheDataSource
import ru.pyroman.medanalytica.data.token.repository.TokenRepositoryImpl
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository

@Module
interface TokenDataModule {

    @Binds
    fun bindTokenRepository(impl: TokenRepositoryImpl): TokenRepository

    companion object {
        @Provides
        internal fun provideTokenCacheDataStore(
            applicationContext: Context,
        ): TokenCacheDataSource {
            return TokenCacheDataSource(
                applicationContext = applicationContext,
            )
        }

        @Provides
        internal fun provideTokenRepositoryImpl(
            cacheDataSource: TokenCacheDataSource,
        ): TokenRepositoryImpl {
            return TokenRepositoryImpl(
                cacheDataSource = cacheDataSource,
            )
        }
    }

}