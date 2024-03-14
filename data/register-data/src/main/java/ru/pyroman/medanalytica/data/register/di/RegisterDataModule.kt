package ru.pyroman.medanalytica.data.register.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.register.network.RegisterNetworkDataSource
import ru.pyroman.medanalytica.data.register.network.RegisterNetworkMapper
import ru.pyroman.medanalytica.data.register.network.api.RegisterNetworkApi
import ru.pyroman.medanalytica.data.register.repository.RegisterRepositoryImpl
import ru.pyroman.medanalytica.domain.register.repository.RegisterRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository

@Module
interface RegisterDataModule {

    @Binds
    fun bindRegisterRepository(
        impl: RegisterRepositoryImpl,
    ): RegisterRepository

    companion object {

        @Provides
        internal fun provideRegisterNetworkApi(): RegisterNetworkApi {
            return RegisterNetworkApi.build()
        }

        @Provides
        internal fun provideRegisterNetworkMapper(): RegisterNetworkMapper {
            return RegisterNetworkMapper()
        }

        @Provides
        internal fun provideRegisterNetworkDataSource(
            api: RegisterNetworkApi
        ): RegisterNetworkDataSource {
            return RegisterNetworkDataSource(
                api = api,
            )
        }

        @Provides
        internal fun provideRegisterRepositoryImpl(
            uidRepository: UidRepository,
            tokenRepository: TokenRepository,
            networkDataSource: RegisterNetworkDataSource,
            networkMapper: RegisterNetworkMapper,
        ): RegisterRepositoryImpl {
            return RegisterRepositoryImpl(
                uidRepository = uidRepository,
                tokenRepository = tokenRepository,
                networkDataSource = networkDataSource,
                networkMapper = networkMapper,
            )
        }
    }
}