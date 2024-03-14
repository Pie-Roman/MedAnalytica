package ru.pyroman.medanalytica.domain.register.repository

import ru.pyroman.medanalytica.domain.register.model.RegisterData
import ru.pyroman.medanalytica.domain.register.model.RegisterResult

interface RegisterRepository {

    suspend fun register(data: RegisterData): RegisterResult
}