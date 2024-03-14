package ru.pyroman.medanalytica.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun StyledTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    color: Color,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = text,
            color = textColor,
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        )
    }
}