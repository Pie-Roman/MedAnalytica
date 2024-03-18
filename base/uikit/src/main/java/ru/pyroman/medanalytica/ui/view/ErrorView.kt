package ru.pyroman.medanalytica.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.ui.theme.Red

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Red)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.padding(8.dp),
            imageVector = Icons.Default.Warning,
            contentDescription = null,
            tint = Color.White,
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = text,
            fontWeight = FontWeight.Medium,
            color = Color.White,
        )
    }
}

@Preview(showBackground = false)
@Composable
fun ErrorView_Preview() {
    WarningView(text = "Ошибка!")
}