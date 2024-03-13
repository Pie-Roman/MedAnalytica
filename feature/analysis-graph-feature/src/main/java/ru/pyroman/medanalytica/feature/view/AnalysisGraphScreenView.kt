package ru.pyroman.medanalytica.feature.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.analysisgraph.R
import ru.pyroman.medanalytica.feature.state.AnalysisGraphState
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListErrorView
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListLoadingView
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListSuccessView
import ru.pyroman.medanalytica.feature.view.search.AnalysisGraphSearchView
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModel
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModelFactory
import ru.pyroman.medanalytica.base.uikit.R as UiKitR

@Composable
fun AnalysisGraphScreenView(
    viewModelFactory: AnalysisGraphViewModelFactory,
    navController: NavController,
) {
    val viewModel: AnalysisGraphViewModel = viewModel(
        factory = viewModelFactory,
    )
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    AnalysisGraphListView(
        state = state,
        navController = navController,
        onIdle = {
            viewModel.onRefresh()
        },
        onRefresh = {
            viewModel.onRefresh()
        },
        onSearchInput = { searchInput ->
            viewModel.onSearchInput(searchInput)
        },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnalysisGraphListView(
    state: AnalysisGraphState,
    navController: NavController,
    onIdle: () -> Unit,
    onRefresh: () -> Unit,
    onSearchInput: (String) -> Unit,
) {
    val isRefreshing = state == AnalysisGraphState.Loading
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onRefresh,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullRefreshState,
            modifier = Modifier
                .zIndex(1f)
                .align(Alignment.TopCenter),
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = 32.dp,
                        bottom = 16.dp,
                    ),
            )

            Text(
                text = "Анализы",
                fontSize = TextUnit(28f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
            )

            AnalysisGraphSearchView(
                modifier = Modifier
                    .padding(
                        vertical = 16.dp,
                    ),
            ) { searchInput ->
                onSearchInput(searchInput)
            }

            when (state) {
                is AnalysisGraphState.Idle ->
                    onIdle()

                is AnalysisGraphState.Loading ->
                    AnalysisGraphListLoadingView()

                is AnalysisGraphState.Success ->
                    AnalysisGraphListSuccessView(
                        vo = state.graphListVo,
                    )

                is AnalysisGraphState.Error ->
                    AnalysisGraphListErrorView()
            }
        }

        Button(
            modifier = Modifier
                .padding(all = 16.dp)
                .size(60.dp)
                .align(Alignment.BottomEnd),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                colorResource(id = UiKitR.color.lightBlue)
            ),
            onClick = {
                navController.navigate(Screen.PostAnalysis.route)
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                tint = Color.White,
            )
        }
    }
}