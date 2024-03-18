package ru.pyroman.medanalytica.feature.view.graphlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.feature.view.graph.AnalysisGraphView
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphListVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphWarningVo
import ru.pyroman.medanalytica.ui.view.WarningView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnalysisGraphListSuccessView(
    vo: AnalysisGraphListVo,
    warningVo: AnalysisGraphWarningVo?,
) {
    LazyColumn(
        modifier = Modifier.padding(top = 16.dp),
    ) {
        if (warningVo != null) {
            stickyHeader {
                WarningView(text = warningVo.warningText)
            }
        }

        items(vo.graphs) { graphVo ->
            AnalysisGraphView(
                vo = graphVo,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
        }
    }
}