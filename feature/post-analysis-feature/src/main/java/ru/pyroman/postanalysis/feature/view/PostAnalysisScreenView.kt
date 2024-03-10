package ru.pyroman.postanalysis.feature.view

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.pyroman.postanalysis.feature.state.PostAnalysisState
import ru.pyroman.postanalysis.feature.view.documentpicker.DocumentPickerButton
import ru.pyroman.postanalysis.feature.viewmodel.PostAnalysisViewModel
import ru.pyroman.postanalysis.feature.viewmodel.PostAnalysisViewModelFactory

@Composable
fun PostAnalysisScreenView(
    viewModelFactory: PostAnalysisViewModelFactory,
) {
    val viewModel: PostAnalysisViewModel = viewModel (
        factory = viewModelFactory,
    )
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    PostAnalysisView(
        state = state,
        onFileInput = viewModel::onFileInput,
    )
}

@Composable
private fun PostAnalysisView(
    state: PostAnalysisState,
    onFileInput: (Uri) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        DocumentPickerButton(
            onDocumentPicked = onFileInput,
        )
    }
}