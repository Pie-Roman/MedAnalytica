package ru.pyroman.medanalytica.domain.profile.domain

enum class BloodType(val value: String) {
    A_PLUS("A+"),
    A_MINUS("A-"),
    B_PLUS("B+"),
    B_MINUS("B-"),
    AB_PLUS("AB+"),
    AB_MINUS("AB-"),
    O_PLUS("O+"),
    O_MINUS("O-");

    companion object {
        fun fromValue(value: String): BloodType? {
            val valueToEnumMap = BloodType.entries
                .asSequence()
                .map { bloodType ->
                    bloodType.value to bloodType
                }
                .toMap()

            return valueToEnumMap[value]
        }
    }
}