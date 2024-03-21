package ru.pyroman.medanalytica.feature.profile.view.input

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.domain.profile.domain.BloodType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BloodTypePickerView(
    selectedBloodType: BloodType?,
    onBloodTypeSelected: (BloodType) -> Unit,
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val bloodTypes = BloodType.entries.toTypedArray()

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it},
    ) {
        Text(
            text = selectedBloodType?.value.orEmpty(),
            color = Color.Black,
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        )

        ExposedDropdownMenu(
            modifier = Modifier
                .width(64.dp),
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            bloodTypes.forEach { bloodType ->
                DropdownMenuItem(
                    contentPadding = PaddingValues(
                        horizontal = 8.dp
                    ),
                    onClick = {
                        isExpanded = false
                        onBloodTypeSelected(bloodType)
                    }
                ) {
                    Text(
                        text = bloodType.value,
                        fontSize = TextUnit(14f, TextUnitType.Sp),
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}