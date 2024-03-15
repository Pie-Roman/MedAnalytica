package ru.pyroman.medanalytica.postanalysis.feature.view.post

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.postanalysis.feature.view.documentpicker.DocumentPickerButton
import ru.pyroman.medanalytica.ui.view.ErrorView

@Composable
fun PostAnalysisErrorView(
    errorMessage: String,
    onFileInput: (Uri) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        ErrorView(
            text = errorMessage,
        )

        Spacer(modifier = Modifier
            .height(16.dp)
        )

        DocumentPickerButton(
            onDocumentPicked = onFileInput,
        )
    }
}