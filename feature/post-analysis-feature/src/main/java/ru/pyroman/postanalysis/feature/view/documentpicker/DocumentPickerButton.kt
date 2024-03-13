package ru.pyroman.postanalysis.feature.view.documentpicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DocumentPickerButton(
    onDocumentPicked: (Uri) -> Unit,
) {
    val pickFileLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri != null) {
            onDocumentPicked(uri)
        }
    }
    Button(onClick = {
        pickFileLauncher.launch(arrayOf("application/pdf"))
    }) {
        Text("Загрузить отчёт")
    }
}