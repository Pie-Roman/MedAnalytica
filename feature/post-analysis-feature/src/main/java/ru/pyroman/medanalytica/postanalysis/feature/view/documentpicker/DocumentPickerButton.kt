package ru.pyroman.medanalytica.postanalysis.feature.view.documentpicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import ru.pyroman.medanalytica.ui.view.StyledTextButton
import ru.pyroman.medanalytica.base.uikit.R as UiKitR

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
    StyledTextButton(
        text = "Загрузить\nанализ",
        textColor = colorResource(id = UiKitR.color.lightBlue),
        color = Color.Transparent,
        onClick = {
            pickFileLauncher.launch(arrayOf("application/pdf"))
        }
    )
}