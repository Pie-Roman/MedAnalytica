package ru.pyroman.medanalytica.feature.profile.view.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.base.uikit.R

@Composable
fun InputSeparator() {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(color = colorResource(id = R.color.lightGray))
        .padding(vertical = 8.dp),
    )
}