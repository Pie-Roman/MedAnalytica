package ru.pyroman.medanalytica.feature.profile.view.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.base.uikit.R
import ru.pyroman.medanalytica.ui.view.ErrorView

@Composable
fun ProfileErrorView(
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.lightGray))
            .padding(horizontal = 16.dp)

    ) {
        ProfileHeaderView(
            onBackClick = onBackClick,
        )

        Spacer(modifier = Modifier.height(16.dp))

        ErrorView(
            text = "Ошибка загрузки профиля. Повторите попытку позже!"
        )
    }
}