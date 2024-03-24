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
import ru.pyroman.medanalytica.feature.profile.vo.DateOfBirthVo

@Composable
fun DateInputView(
    vo: DateOfBirthVo,
    onDateSelected: (Int, Int, Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Дата рождения",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        )

        val dateVo = vo.dateVo

        if (dateVo != null) {
            DatePickerView(
                text = vo.text,
                currYear = dateVo.year,
                currMonth = dateVo.month,
                currDay = dateVo.day,
                onDateSelected = onDateSelected,
            )
        } else {
            DatePickerView(
                text = vo.text,
                onDateSelected = onDateSelected,
            )
        }
    }
}