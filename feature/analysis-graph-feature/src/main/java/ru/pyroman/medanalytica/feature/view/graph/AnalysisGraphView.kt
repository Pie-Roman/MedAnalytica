package ru.pyroman.medanalytica.feature.view.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphDataVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphPointVo

@Composable
fun AnalysisGraphView(
    vo: AnalysisGraphDataVo,
) {
    Chart(
        chart = lineChart(),
        chartModelProducer = ChartEntryModelProducer(vo.points),
        startAxis = rememberStartAxis(),
        bottomAxis = rememberBottomAxis(),
    )
}

@Preview(showBackground = true)
@Composable
fun AnalysisGraphView_Preview() {
    val vo = AnalysisGraphDataVo(
        analysisType = "MCH",
        points = listOf(
            AnalysisGraphPointVo(
                creationDateTime = "25.01.2024",
                index = 0f,
                value = 87.3f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "01.02.2024",
                index = 1f,
                value = 85.0f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "14.02.2024",
                index = 3f,
                value = 90.1f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "25.02.2024",
                index = 4f,
                value = 84.2f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "03.03.2024",
                index = 5f,
                value = 86.3f,
            )
        )
    )

    AnalysisGraphView (
        vo = vo,
    )
}