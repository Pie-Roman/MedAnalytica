package ru.pyroman.medanalytica.feature.profile.view.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun TextInputView(
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    inputText: String,
    inputTextHint: String,
    onValueChange: (String) -> Unit,
) {
    BasicTextField(
        value = inputText,
        textStyle = TextStyle(
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontWeight = FontWeight.Normal,
        ),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange,
        decorationBox = { textField ->
            Box(
                modifier = modifier
                    .padding(
                        vertical = 8.dp,
                    ),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (inputText.isEmpty()) {
                    Text(
                        text = inputTextHint,
                        fontSize = TextUnit(14f, TextUnitType.Sp),
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                    )
                }
                textField()
            }
        },
    )
}