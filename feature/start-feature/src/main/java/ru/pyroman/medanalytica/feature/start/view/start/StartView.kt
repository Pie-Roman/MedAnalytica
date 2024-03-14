package ru.pyroman.medanalytica.feature.start.view.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.base.uikit.R
import ru.pyroman.medanalytica.ui.view.StyledTextButton

@Composable
fun StartView(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        StyledTextButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Войти",
            textColor = Color.White,
            color = colorResource(id = R.color.lightBlue),
            onClick = onLoginClick,
        )

        Spacer(modifier = Modifier.height(8.dp))

        StyledTextButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Зарегистрироваться",
            textColor = colorResource(id = R.color.lightBlue),
            color = Color.Transparent,
            onClick = onRegisterClick,
        )
    }
}