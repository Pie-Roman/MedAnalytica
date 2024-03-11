package ru.pyroman.postanalysis.feature.view

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.pyroman.postanalysis.feature.state.PostAnalysisState
import ru.pyroman.postanalysis.feature.view.documentpicker.DocumentPickerButton
import ru.pyroman.postanalysis.feature.view.post.PostAnalysisErrorView
import ru.pyroman.postanalysis.feature.view.post.PostAnalysisLoadingView
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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (state) {
            is PostAnalysisState.Idle -> {
                DocumentPickerButton(
                    onDocumentPicked = onFileInput,
                )
            }
            is PostAnalysisState.Loading -> {
                PostAnalysisLoadingView()
            }
            is PostAnalysisState.Success -> {

            }
            is PostAnalysisState.Error -> {
                PostAnalysisErrorView(
                    onFileInput = onFileInput,
                )
            }
        }
    }
}