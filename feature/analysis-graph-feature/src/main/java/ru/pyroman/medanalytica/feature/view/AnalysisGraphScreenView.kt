package ru.pyroman.medanalytica.feature.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.pyroman.medanalytica.feature.state.AnalysisGraphState
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListErrorView
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListLoadingView
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListSuccessView
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModel
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModelFactory

@Composable
fun AnalysisGraphScreenView(
    viewModelFactory: AnalysisGraphViewModelFactory,
) {
    val viewModel: AnalysisGraphViewModel = viewModel(
        factory = viewModelFactory,
    )
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    AnalysisGraphListView(
        state = state,
        onIdle = {
            viewModel.fetchGraphList()
        },
    )
}

@Composable
fun AnalysisGraphListView(
    state: AnalysisGraphState,
    onIdle: () -> Unit,
) {
    when (state) {
        is AnalysisGraphState.Idle ->
            onIdle()

        is AnalysisGraphState.Loading ->
            AnalysisGraphListLoadingView()

        is AnalysisGraphState.Success ->
            AnalysisGraphListSuccessView(state.graphListVo)

        is AnalysisGraphState.Error ->
            AnalysisGraphListErrorView()
    }
}