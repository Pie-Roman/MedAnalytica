package ru.pyroman.medanalytica.ui.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.base.uikit.R

@Composable
fun InputView(
    modifier: Modifier = Modifier,
    inputTextHint: String,
    inputText: String = "",
    onValueChange: (String) -> Unit,
) {
    BasicTextField(
        value = inputText,
        textStyle = TextStyle(
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
        ),
        onValueChange = onValueChange,
        decorationBox = { textField ->
            Box(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .border(
                        width = 1.dp,
                        color = colorResource(R.color.gray),
                        shape = RoundedCornerShape(8.dp),
                    )
                    .padding(
                        vertical = 8.dp,
                        horizontal = 12.dp,
                    ),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (inputText.isEmpty()) {
                    Text(
                        text = inputTextHint,
                        fontSize = TextUnit(20f, TextUnitType.Sp),
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                    )
                }
                textField()
            }
        },
    )
}