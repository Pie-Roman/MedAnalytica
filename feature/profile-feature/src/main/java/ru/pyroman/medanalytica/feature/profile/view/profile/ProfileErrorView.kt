package ru.pyroman.medanalytica.feature.profile.view.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.base.uikit.R
import ru.pyroman.medanalytica.ui.view.ErrorView
import ru.pyroman.medanalytica.ui.view.StyledTextButton

@Composable
fun ProfileErrorView(
    onBackClick: () -> Unit,
    onRetryClick: () -> Unit,
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

        Spacer(modifier = Modifier.height(16.dp))

        StyledTextButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Перезагрузить страницу",
            textColor = Color.White,
            color = colorResource(id = R.color.lightBlue),
            onClick = onRetryClick,
        )
    }
}