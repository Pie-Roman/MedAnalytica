package ru.pyroman.medanalytica.feature.profile.view.input

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.ui.view.StyledTextButton
import java.util.Calendar
import ru.pyroman.medanalytica.base.uikit.R as UiKitR

@Composable
fun DatePickerView(
    text: String,
    onDateSelected: (Int, Int, Int) -> Unit,
) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    DatePickerView(
        text = text,
        currYear = year,
        currMonth = month,
        currDay = day,
        onDateSelected = onDateSelected,
    )
}

@Composable
fun DatePickerView(
    text: String,
    currYear: Int,
    currMonth: Int,
    currDay: Int,
    onDateSelected: (Int, Int, Int) -> Unit,
) {
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            onDateSelected(year, month, dayOfMonth)
        },
        currYear,
        currMonth,
        currDay,
    )

    StyledTextButton(
        text = text,
        contentPadding = PaddingValues(
            horizontal = 8.dp,
            vertical = 4.dp,
        ),
        fontSize = TextUnit(14f, TextUnitType.Sp),
        fontWeight = FontWeight.Normal,
        textColor = Color.Black,
        color = colorResource(id = UiKitR.color.lightGray),
        onClick = {
            datePickerDialog.show()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DatePickerView_Preview() {
    DatePickerView(
        text = "4 марта 2024",
        onDateSelected = { _, _, _ -> }
    )
}