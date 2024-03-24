package ru.pyroman.medanalytica.feature.profile.view.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.domain.profile.domain.BloodType

@Composable
fun BloodTypeInputView(
    selectedBloodType: BloodType?,
    onBloodTypeSelected: (BloodType) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Группа крови",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        )

        BloodTypePickerView(
            selectedBloodType = selectedBloodType,
            onBloodTypeSelected = onBloodTypeSelected,
        )
    }
}