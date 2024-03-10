package ru.pyroman.medanalytica.feature.view.graph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
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
    modifier: Modifier = Modifier,
) {
    val spacing = 70.dp
    val padding = spacing / 2

    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.LightGray)
            .padding(vertical = 20.dp, horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 20.dp),
            text = vo.analysisType,
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontWeight = FontWeight.Medium,
        )
        Chart(
            modifier = Modifier
                .background(color = Color.White)
                .padding(all = 8.dp),
            chart = lineChart(
                lines = listOf(
                    LineChart.LineSpec(
                        lineColor = android.graphics.Color.BLUE,
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
                value = 29.015984196295115f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "01.02.24",
                index = 1f,
                value = 29.50865727482566f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "14.02.24",
                index = 2f,
                value = 29.442542479068127f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "25.02.24",
                index = 3f,
                value = 27.93975153381725f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "03.03.24",
                index = 4f,
                value = 29.161417639230358f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "25.01.24",
                index = 5f,
                value = 30.563884907956215f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "01.02.24",
                index = 6f,
                value = 34.44097615853632f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "14.02.24",
                index = 7f,
                value = 30.987861593356058f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "25.02.24",
                index = 8f,
                value = 29.523395305956754f,
            ),
            AnalysisGraphPointVo(
                creationDateTime = "03.03.24",
                index = 9f,
                value = 31.56601234680911f,
            ),
        )
    )

    AnalysisGraphView (
        vo = vo,
    )
}