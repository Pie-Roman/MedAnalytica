package ru.pyroman.medanalytica.domain.uid.repository

import ru.pyroman.medanalytica.domain.uid.model.Uid

interface UidRepository {

    suspend fun setUid(uid: Uid)

    suspend fun getUid(): Uid?
}