package ru.pyroman.medanalytica.feature.view.graph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer
import ru.pyroman.medanalytica.base.uikit.R

@Composable
fun AnalysisGraphLoadingView(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = colorResource(R.color.lightGray))
            .shimmer()
            .padding(vertical = 20.dp, horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .width(44.dp)
                .height(20.dp)
                .align(Alignment.Start)
                .background(color = colorResource(id = R.color.gray)),
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(216.dp)
                .background(color = colorResource(id = R.color.gray)),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnalysisGraphLoadingView_Preview() {
    AnalysisGraphLoadingView()
}