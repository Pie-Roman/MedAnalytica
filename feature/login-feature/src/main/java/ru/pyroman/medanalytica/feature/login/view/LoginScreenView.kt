package ru.pyroman.medanalytica.feature.login.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.pyroman.medanalytica.common.navigation.api.Screen
import ru.pyroman.medanalytica.domain.login.model.LoginData
import ru.pyroman.medanalytica.feature.login.state.LoginState
import ru.pyroman.medanalytica.feature.login.viewmodel.LoginViewModel
import ru.pyroman.medanalytica.feature.login.viewmodel.LoginViewModelFactory
import ru.pyroman.medanalytica.ui.view.InputView
import ru.pyroman.medanalytica.ui.view.StyledTextButton
import ru.pyroman.medanalytica.base.uikit.R as UiKitR

@Composable
fun LoginScreenView(
    viewModelFactory: LoginViewModelFactory,
    navController: NavController,
) {
    val viewModel: LoginViewModel = viewModel(
        factory = viewModelFactory,
    )
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    if (state == LoginState.Success) {
        navController.navigate(Screen.AnalysisGraph.route)
    }

    LoginView(
        onLogin = viewModel::onLogin,
        onBack = { navController.navigateUp() }
    )
}

@Composable
private fun LoginView(
    onLogin: (LoginData) -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var loginText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }

        InputView(
            modifier = Modifier
                .fillMaxWidth(),
            inputTextHint = "Логин",
            inputText = loginText,
            onValueChange = { newValue ->
                loginText = newValue
            }
        )

        Spacer(modifier = Modifier.height(22.dp))

        InputView(
            modifier = Modifier
                .fillMaxWidth(),
            inputTextHint = "Пароль",
            inputText = passwordText,
            onValueChange = { newValue ->
                passwordText = newValue
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        StyledTextButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Войти",
            textColor = Color.White,
            color = colorResource(id = UiKitR.color.lightBlue),
            onClick = {
                val loginData = LoginData(
                    login = loginText,
                    password = passwordText,
                )
                onLogin(loginData)
            },
        )

        Spacer(modifier = Modifier.height(8.dp))

        StyledTextButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Назад",
            textColor = colorResource(id = UiKitR.color.lightBlue),
            color = Color.Transparent,
            onClick = onBack,
        )
    }
}