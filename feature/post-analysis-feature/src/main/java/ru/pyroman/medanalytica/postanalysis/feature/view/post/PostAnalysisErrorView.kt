package ru.pyroman.medanalytica.postanalysis.feature.view.post

import android.net.Uri
import androidx.compose.runtime.Composable
import ru.pyroman.medanalytica.postanalysis.feature.view.documentpicker.DocumentPickerButton

@Composable
fun PostAnalysisErrorView(
    onFileInput: (Uri) -> Unit,
) {
    DocumentPickerButton(
        onDocumentPicked = onFileInput,
    )
}