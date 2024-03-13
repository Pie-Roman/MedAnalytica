package ru.pyroman.postanalysis.feature.view

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.pyroman.medanalytica.feature.postanalysis.R
import ru.pyroman.postanalysis.feature.state.PostAnalysisState
import ru.pyroman.postanalysis.feature.view.documentpicker.DocumentPickerButton
import ru.pyroman.postanalysis.feature.view.post.PostAnalysisErrorView
import ru.pyroman.postanalysis.feature.view.post.PostAnalysisLoadingView
import ru.pyroman.postanalysis.feature.viewmodel.PostAnalysisViewModel
import ru.pyroman.postanalysis.feature.viewmodel.PostAnalysisViewModelFactory

@Composable
fun PostAnalysisScreenView(
    viewModelFactory: PostAnalysisViewModelFactory,
    navController: NavController,
) {
    val viewModel: PostAnalysisViewModel = viewModel (
        factory = viewModelFactory,
    )
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    PostAnalysisView(
        state = state,
        navController = navController,
        onFileInput = viewModel::onFileInput,
    )
}

@Composable
private fun PostAnalysisView(
    state: PostAnalysisState,
    navController: NavController,
    onFileInput: (Uri) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        TextButton(
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.TopStart),
            onClick = {
                navController.navigateUp()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
            )
        }

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
                Text(
                    text = "Success"
                )
            }
            is PostAnalysisState.Error -> {
                PostAnalysisErrorView(
                    onFileInput = onFileInput,
                )
            }
        }
    }
}