package ru.pyroman.medanalytica.feature.profile.formatter

import ru.pyroman.medanalytica.domain.profile.domain.ProfileData
import ru.pyroman.medanalytica.feature.profile.utils.makeDate
import ru.pyroman.medanalytica.feature.profile.utils.makeDateOfBirthVo
import ru.pyroman.medanalytica.feature.profile.vo.DateOfBirthVo
import ru.pyroman.medanalytica.feature.profile.vo.ProfileDataVo
import java.text.SimpleDateFormat
import java.util.Locale

class ProfileFormatter {

    private val dateFormat = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())

    fun format(data: ProfileData): ProfileDataVo {
        val name = data.name
        val surname = data.surname
        val dateOfBirth = formatDateOfBirth(data.dateOfBirth)
        val weight = data.weight?.toString().orEmpty()
        val height = data.height?.toString().orEmpty()
        val bloodType = data.bloodType

        return ProfileDataVo(
            name = name,
            surname = surname,
            dateOfBirth = dateOfBirth,
            weight = weight,
            height = height,
            bloodType = bloodType,
        )
    }

    fun format(vo: ProfileDataVo): ProfileData {
        val name = vo.name
        val surname = vo.surname
        val dateOfBirth = formatDateOfBirth(vo.dateOfBirth).orEmpty()
        val weight = vo.weight.toIntOrNull()
        val height = vo.height.toIntOrNull()
        val bloodType = vo.bloodType

        return ProfileData(
            name = name,
            surname = surname,
            dateOfBirth = dateOfBirth,
            weight = weight,
            height = height,
            bloodType = bloodType,
        )
    }

    private fun formatDateOfBirth(date: String): DateOfBirthVo {
        return try {
            dateFormat.parse(date)?.let {
                makeDateOfBirthVo(it)
            } ?: formatEmptyDateOfBirth()
        } catch (error: Throwable) {
            formatEmptyDateOfBirth()
        }
    }

    private fun formatEmptyDateOfBirth(): DateOfBirthVo {
        return DateOfBirthVo(
            text = "Не выбрано",
            dateVo = null,
        )
    }

    private fun formatDateOfBirth(vo: DateOfBirthVo): String? {
        val dateVo = vo.dateVo ?: return null
        val date = makeDate(
            year = dateVo.year,
            month = dateVo.month,
            day = dateVo.day,
        )
        return dateFormat.format(date)
    }
}