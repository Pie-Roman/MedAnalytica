package ru.pyroman.medanalytica.data.start.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.start.repository.StartRepositoryImpl
import ru.pyroman.medanalytica.domain.start.repository.StartRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository

@Module
interface StartDataModule {

    @Binds
    fun bindStartRepository(impl: StartRepositoryImpl): StartRepository

    companion object {

        @Provides
        internal fun provideStartRepositoryImpl(
            uidRepository: UidRepository,
            tokenRepository: TokenRepository,
        ): StartRepositoryImpl {
            return StartRepositoryImpl(
                uidRepository = uidRepository,
                tokenRepository = tokenRepository,
            )
        }
    }
}