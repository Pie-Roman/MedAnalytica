package ru.pyroman.medanalytica.feature.profile.view.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.pyroman.medanalytica.domain.profile.domain.BloodType
import ru.pyroman.medanalytica.feature.profile.state.ProfileState
import ru.pyroman.medanalytica.feature.profile.vo.DateOfBirthVo
import ru.pyroman.medanalytica.feature.profile.vo.ProfileDataVo

@Composable
fun ProfileView(
    state: ProfileState
) {
    val dateOfBirthVo = DateOfBirthVo(
        text = "4 марта 2024г.",
        dateVo = null,
    )

    val vo = ProfileDataVo(
        name = "User",
        surname = "User",
        dateOfBirth = dateOfBirthVo,
        weight = "127",
        height = "189",
        bloodType = BloodType.AB_MINUS,
    )

    ProfileSuccessView(
        vo = vo
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileView_Preview() {
    ProfileView(
        state = ProfileState.Idle
    )
}