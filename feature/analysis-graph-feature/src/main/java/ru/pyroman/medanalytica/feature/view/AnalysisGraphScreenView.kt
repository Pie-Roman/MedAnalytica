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

@Composable
fun AnalysisGraphScreenView(
    viewModel: AnalysisGraphViewModel = viewModel(),
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    AnalysisGraphListView(
        state = state,
    )
}

@Composable
fun AnalysisGraphListView(
    state: AnalysisGraphState
) {
    when (state) {
        is AnalysisGraphState.Loading ->
            AnalysisGraphListLoadingView()

        is AnalysisGraphState.Success ->
            AnalysisGraphListSuccessView(state.graphListVo)

        is AnalysisGraphState.Error ->
            AnalysisGraphListErrorView()
    }
}