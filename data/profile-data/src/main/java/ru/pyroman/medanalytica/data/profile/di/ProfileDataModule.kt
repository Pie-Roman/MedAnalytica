package ru.pyroman.medanalytica.data.profile.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pyroman.medanalytica.data.profile.network.ProfileNetworkDataSource
import ru.pyroman.medanalytica.data.profile.network.ProfileNetworkMapper
import ru.pyroman.medanalytica.data.profile.network.api.ProfileNetworkApi
import ru.pyroman.medanalytica.data.profile.repository.ProfileRepositoryImpl
import ru.pyroman.medanalytica.domain.profile.repository.ProfileRepository
import ru.pyroman.medanalytica.domain.token.repository.TokenRepository
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository

@Module
interface ProfileDataModule {

    @Binds
    fun bindProfileRepository(
        impl: ProfileRepositoryImpl,
    ): ProfileRepository

    companion object {

        @Provides
        internal fun provideProfileNetworkApi(): ProfileNetworkApi {
            return ProfileNetworkApi.build()
        }

        @Provides
        internal fun provideProfileNetworkMapper(): ProfileNetworkMapper {
            return ProfileNetworkMapper()
        }

        @Provides
        internal fun provideProfileNetworkDataSource(
            api: ProfileNetworkApi
        ): ProfileNetworkDataSource {
            return ProfileNetworkDataSource(
                api = api,
            )
        }

        @Provides
        internal fun provideProfileRepositoryImpl(
            uidRepository: UidRepository,
            tokenRepository: TokenRepository,
            networkDataSource: ProfileNetworkDataSource,
            networkMapper: ProfileNetworkMapper,
        ): ProfileRepositoryImpl {
            return ProfileRepositoryImpl(
                uidRepository = uidRepository,
                tokenRepository = tokenRepository,
                networkDataSource = networkDataSource,
                networkMapper = networkMapper,
            )
        }
    }
}