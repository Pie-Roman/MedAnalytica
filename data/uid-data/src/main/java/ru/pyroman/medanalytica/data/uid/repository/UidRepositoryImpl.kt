package ru.pyroman.medanalytica.data.uid.repository

import ru.pyroman.medanalytica.data.uid.cache.UidCacheDataSource
import ru.pyroman.medanalytica.domain.uid.model.Uid
import ru.pyroman.medanalytica.domain.uid.repository.UidRepository
import javax.inject.Inject

class UidRepositoryImpl @Inject internal constructor(
    private val cacheDataSource: UidCacheDataSource,
) : UidRepository {
    override suspend fun setUid(uid: Uid) {
        return cacheDataSource.setUid(uid)
    }

    override suspend fun getUid(): Uid? {
        return cacheDataSource.getUid()
    }
}