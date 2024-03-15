package ru.pyroman.medanalytica.feature.view.graphlist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.feature.view.graph.AnalysisGraphLoadingView

@Composable
fun AnalysisGraphListLoadingView() {
    LazyColumn(
        modifier = Modifier.padding(top = 16.dp),
    ) {
        items(count = 3) {
            AnalysisGraphLoadingView(
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnalysisGraphListLoadingView_Preview() {
    AnalysisGraphListLoadingView()
}