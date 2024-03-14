package ru.pyroman.medanalytica.data.login.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.login.network.LoginNetworkDataSource
import ru.pyroman.medanalytica.data.login.network.LoginNetworkMapper
import ru.pyroman.medanalytica.data.login.network.api.LoginNetworkApi
import ru.pyroman.medanalytica.data.login.repository.LoginRepositoryImpl
import ru.pyroman.medanalytica.domain.login.repository.LoginRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository

@Module
interface LoginDataModule {

    @Binds
    fun bindLoginRepository(
        impl: LoginRepositoryImpl,
    ): LoginRepository

    companion object {

        @Provides
        internal fun provideLoginNetworkApi(): LoginNetworkApi {
            return LoginNetworkApi.build()
        }

        @Provides
        internal fun provideLoginNetworkMapper(): LoginNetworkMapper {
            return LoginNetworkMapper()
        }

        @Provides
        internal fun provideLoginNetworkDataSource(
            api: LoginNetworkApi
        ): LoginNetworkDataSource {
            return LoginNetworkDataSource(
                api = api,
            )
        }

        @Provides
        internal fun provideLoginRepositoryImpl(
            uidRepository: UidRepository,
            tokenRepository: TokenRepository,
            networkDataSource: LoginNetworkDataSource,
            networkMapper: LoginNetworkMapper,
        ): LoginRepositoryImpl {
            return LoginRepositoryImpl(
                uidRepository = uidRepository,
                tokenRepository = tokenRepository,
                networkDataSource = networkDataSource,
                networkMapper = networkMapper,
            )
        }
    }
}