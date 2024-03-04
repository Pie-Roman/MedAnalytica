package ru.pyroman.medanalytica.feature.view.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.layout.fullWidth
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollSpec
import com.patrykandpatrick.vico.core.axis.Axis
import com.patrykandpatrick.vico.core.chart.DefaultPointConnector
import com.patrykandpatrick.vico.core.chart.layout.HorizontalLayout
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.chart.values.AxisValuesOverrider
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.scroll.InitialScroll
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphDataVo
import ru.pyroman.medanalytica.feature.vo.AnalysisGraphPointVo

@Composable
fun AnalysisGraphView(
    vo: AnalysisGraphDataVo,
) {
    val spacing = 70.dp
    val padding = spacing / 2

    Chart(
        chart = lineChart(
            lines = listOf(
                LineChart.LineSpec(
                    pointConnector = DefaultPointConnector(
                        cubicStrength = 0f,
                    )
                )
            ),
            spacing = spacing,
            axisValuesOverrider = AxisValuesOverrider.adaptiveYValues(
                yFraction = 1.01f,
                round = true,
            )
        ),
        chartModelProducer = ChartEntryModelProducer(vo.points),
        startAxis = rememberStartAxis(),
        bottomAxis = rememberBottomAxis(
            valueFormatter = { value, _ ->
                vo.points[value.toInt()].creationDateTime
            },
            sizeConstraint = Axis.SizeConstraint.TextWidth("DD.MM.YYYY")
        ),
        chartScrollSpec = rememberChartScrollSpec(
            initialScroll = InitialScroll.End,
        ),
        horizontalLayout = HorizontalLayout.fullWidth(
            scalableStartPadding = padding,
            scalableEndPadding = padding,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun AnalysisGraphView_Preview() {
    val vo = AnalysisGraphDataVo(
        analysisType = "MCH",
        points = listOf(
            AnalysisGraphPointVo(
                creationDateTime = "25.01.24",
                index = 0f,
                value = 87.3f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "01.02.24",
                index = 1f,
                value = 85.0f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "14.02.24",
                index = 2f,
                value = 90.1f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "25.02.24",
                index = 3f,
                value = 84.2f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "03.03.24",
                index = 4f,
                value = 86.3f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "25.01.24",
                index = 5f,
                value = 87.3f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "01.02.24",
                index = 6f,
                value = 85.0f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "14.02.24",
                index = 7f,
                value = 90.1f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "25.02.24",
                index = 8f,
                value = 84.2f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "03.03.24",
                index = 9f,
                value = 86.3f,
            ),
        )
    )

    AnalysisGraphView (
        vo = vo,
    )
}