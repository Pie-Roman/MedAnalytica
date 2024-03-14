package ru.pyroman.medanalytica.feature.view.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.feature.analysisgraph.R
import ru.pyroman.medanalytica.base.uikit.R as UiKitR

@Composable
fun AnalysisGraphSearchView(
    modifier: Modifier = Modifier,
    onSearchInput: (String) -> Unit,
) {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        modifier = modifier
            .fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontWeight = FontWeight.Medium,
        ),
        onValueChange = { textFieldValue ->
            text = textFieldValue
            onSearchInput(textFieldValue)
        },
        singleLine = true,
        decorationBox = { textField ->
            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = colorResource(UiKitR.color.lightGray))
                    .padding(
                        top = 2.dp,
                        bottom = 2.dp,
                        start = 8.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 16.dp),
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                    tint = Color.Gray
                )
                Box(
                    contentAlignment = Alignment.CenterStart,
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = "Найти анализ",
                            fontSize = TextUnit(20f, TextUnitType.Sp),
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray,
                        )
                    }
                    textField()
                }
            }
        },
    )
}

@Composable
@Preview(showBackground = false)
fun AnalysisGraphSearchView_Preview() {
    AnalysisGraphSearchView {

    }
}