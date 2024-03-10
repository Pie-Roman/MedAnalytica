package ru.pyroman.medanalytica.feature.view.graphlist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.feature.view.graph.AnalysisGraphView
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphListVo

@Composable
fun AnalysisGraphListSuccessView(
    vo: AnalysisGraphListVo,
) {
    LazyColumn {
        items(vo.graphs) { graphVo ->
            AnalysisGraphView(
                vo = graphVo,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
        }
    }
}