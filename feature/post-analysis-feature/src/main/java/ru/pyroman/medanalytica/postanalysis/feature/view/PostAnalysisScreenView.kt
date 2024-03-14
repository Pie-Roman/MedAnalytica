package ru.pyroman.medanalytica.postanalysis.feature.view

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ru.pyroman.medanalytica.feature.postanalysis.R
import ru.pyroman.medanalytica.postanalysis.feature.state.PostAnalysisState
import ru.pyroman.medanalytica.postanalysis.feature.view.documentpicker.DocumentPickerButton
import ru.pyroman.medanalytica.postanalysis.feature.view.post.PostAnalysisErrorView
import ru.pyroman.medanalytica.postanalysis.feature.view.post.PostAnalysisLoadingView
import ru.pyroman.medanalytica.postanalysis.feature.viewmodel.PostAnalysisViewModel

@Composable
fun PostAnalysisScreenView(
    viewModel: PostAnalysisViewModel,
    navController: NavController,
    onSuccess: () -> Unit,
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    PostAnalysisView(
        state = state,
        navController = navController,
        onFileInput = viewModel::onFileInput,
        onSuccess = {
            navController.navigateUp()
            viewModel.reset()
            onSuccess()
        }
    )
}

@Composable
private fun PostAnalysisView(
    state: PostAnalysisState,
    navController: NavController,
    onSuccess: () -> Unit,
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
                onSuccess()
            }
            is PostAnalysisState.Error -> {
                PostAnalysisErrorView(
                    onFileInput = onFileInput,
                )
            }
        }
    }
}