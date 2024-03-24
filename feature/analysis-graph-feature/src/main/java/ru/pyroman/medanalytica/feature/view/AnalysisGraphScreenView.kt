package ru.pyroman.medanalytica.feature.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.feature.analysisgraph.R
import ru.pyroman.medanalytica.feature.state.AnalysisGraphState
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListErrorView
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListLoadingView
import ru.pyroman.medanalytica.feature.view.graphlist.AnalysisGraphListSuccessView
import ru.pyroman.medanalytica.feature.view.search.AnalysisGraphSearchView
import ru.pyroman.medanalytica.feature.viewmodel.AnalysisGraphViewModel
import ru.pyroman.medanalytica.base.uikit.R as UiKitR

@Composable
fun AnalysisGraphScreenView(
    viewModel: AnalysisGraphViewModel,
    navController: NavController,
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onRefresh()
    }

    AnalysisGraphListView(
        state = state,
        onIdle = viewModel::onRefresh,
        onProfileClick = {
            navController.navigate(Screen.Profile.route)
        },
        onLogoutClick = {
            viewModel.onLogoutClick(
                onComplete = {
                    navController.navigate(Screen.Start.route)
                }
            )
        },
        onRefresh = viewModel::onRefresh,
        onSearchInput = viewModel::onSearchInput,
        onAddAnalysisClick = {
            navController.navigate(Screen.PostAnalysis.route)
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnalysisGraphListView(
    state: AnalysisGraphState,
    onIdle: () -> Unit,
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onRefresh: () -> Unit,
    onSearchInput: (String) -> Unit,
    onAddAnalysisClick: () -> Unit,
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 32.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Анализы",
                    fontSize = TextUnit(28f, TextUnitType.Sp),
                    fontWeight = FontWeight.Bold,
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextButton(
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        onClick = {
                            onProfileClick()
                        }
                    ) {
                        Icon(
                            imageVector  = Icons.Filled.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    TextButton(
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        onClick = {
                            onLogoutClick()
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_logout),
                            contentDescription = null,
                        )
                    }
                }
            }

            AnalysisGraphSearchView(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 16.dp,
                    ),
            ) { searchInput ->
                onSearchInput(searchInput)
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = colorResource(id = UiKitR.color.gray))
                    .padding(vertical = 16.dp),
            )

            when (state) {
                is AnalysisGraphState.Idle ->
                    onIdle()

                is AnalysisGraphState.Loading ->
                    AnalysisGraphListLoadingView()

                is AnalysisGraphState.Success ->
                    AnalysisGraphListSuccessView(
                        vo = state.graphListVo,
                        warningVo = state.warningVo,
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
            onClick = onAddAnalysisClick,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                tint = Color.White,
            )
        }
    }
}