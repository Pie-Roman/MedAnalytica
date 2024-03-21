package ru.pyroman.medanalytica.feature.profile.utils

import ru.pyroman.medanalytica.feature.profile.vo.DateOfBirthVo
import ru.pyroman.medanalytica.feature.profile.vo.DateVo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun makeDate(
    year: Int,
    month: Int,
    day: Int,
): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, day)
    return calendar.time
}

fun makeDateOfBirthVo(
    year: Int,
    month: Int,
    day: Int,
): DateOfBirthVo {
    val date = makeDate(year, month, day)
    return makeDateOfBirthVo(date)
}

fun makeDateOfBirthVo(date: Date): DateOfBirthVo {
    val calendar = Calendar.getInstance()
    calendar.time = date

    val format = SimpleDateFormat("dd MMMM yyyyг.", Locale.getDefault())
    val text = format.format(calendar.time)

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val dateVo = DateVo(
        year = year,
        month = month,
        day = day,
    )

    return DateOfBirthVo(
        text = text,
        dateVo = dateVo,
    )
}