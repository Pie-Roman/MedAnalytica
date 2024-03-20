package ru.pyroman.medanalytica.feature.profile.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.pyroman.medanalytica.feature.profile.viewmodel.ProfileViewModel

@Composable
fun ProfileScreenView(
    viewModel: ProfileViewModel,
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 32.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Профиль",
                fontSize = TextUnit(28f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}