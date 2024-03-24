package ru.pyroman.medanalytica.feature.profile.vo

class DateOfBirthVo(
    val text: String,
    val dateVo: DateVo?,
)

class DateVo(
    val year: Int,
    val month: Int,
    val day: Int,
)