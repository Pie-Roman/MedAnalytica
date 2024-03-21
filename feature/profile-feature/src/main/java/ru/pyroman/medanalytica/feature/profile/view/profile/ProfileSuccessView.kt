package ru.pyroman.medanalytica.feature.profile.view.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import ru.pyroman.medanalytica.domain.profile.domain.BloodType
import ru.pyroman.medanalytica.feature.profile.utils.makeDateOfBirthVo
import ru.pyroman.medanalytica.feature.profile.view.input.BloodTypeInputView
import ru.pyroman.medanalytica.feature.profile.view.input.DateInputView
import ru.pyroman.medanalytica.feature.profile.view.input.InputSectionView
import ru.pyroman.medanalytica.feature.profile.view.input.InputSeparator
import ru.pyroman.medanalytica.feature.profile.view.input.TextInputView
import ru.pyroman.medanalytica.feature.profile.vo.DateOfBirthVo
import ru.pyroman.medanalytica.feature.profile.vo.ProfileDataVo
import ru.pyroman.medanalytica.ui.view.StyledTextButton
import ru.pyroman.medanalytica.base.uikit.R as UiKitR

@Composable
fun ProfileSuccessView(
    vo: ProfileDataVo,
    onProfileInput: (ProfileDataVo) -> Unit,
) {
    var nameText by remember { mutableStateOf(vo.name) }
    var surnameText by remember { mutableStateOf(vo.surname) }
    var dateOfBirth by remember { mutableStateOf(vo.dateOfBirth) }
    var weightText by remember { mutableStateOf(vo.weight) }
    var heightText by remember { mutableStateOf(vo.height) }
    var bloodType by remember { mutableStateOf(vo.bloodType) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = UiKitR.color.lightGray))
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
                text = "Профиль",
                fontSize = TextUnit(28f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier
            .height(12.dp)
        )

        InputSectionView {
            TextInputView(
                inputText = nameText,
                inputTextHint = "Имя",
                onValueChange = { newName -> nameText = newName },
            )

            InputSeparator()

            TextInputView(
                inputText = nameText,
                inputTextHint = "Фамилия",
                onValueChange = { newSurname -> surnameText = newSurname },
            )
        }

        Spacer(modifier = Modifier
            .height(32.dp)
        )

        InputSectionView {
            DateInputView(
                vo = dateOfBirth,
                onDateSelected = { year, month, day ->
                    val dateOfBirthVo = makeDateOfBirthVo(year, month, day)
                    dateOfBirth = dateOfBirthVo
                },
            )

            InputSeparator()

            TextInputView(
                inputText = weightText,
                inputTextHint = "Вес",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { newWeight -> weightText = newWeight },
            )

            InputSeparator()

            TextInputView(
                inputText = heightText,
                inputTextHint = "Рост",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { newHeight -> heightText = newHeight },
            )
        }

        Spacer(modifier = Modifier
            .height(32.dp)
        )

        InputSectionView {
            BloodTypeInputView(
                selectedBloodType = bloodType,
                onBloodTypeSelected = { newBloodType -> bloodType = newBloodType }
            )
        }

        Spacer(modifier = Modifier
            .height(32.dp)
        )

        StyledTextButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Сохранить",
            textColor = Color.White,
            color = colorResource(id = UiKitR.color.lightBlue),
            onClick = {
                val profileDataVo = ProfileDataVo(
                    name = nameText,
                    surname = surnameText,
                    dateOfBirth = dateOfBirth,
                    weight = weightText,
                    height = heightText,
                    bloodType = bloodType,
                )
                onProfileInput(profileDataVo)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileSuccessView_Preview() {
    val dateOfBirthVo = DateOfBirthVo(
        text = "4 марта 2024г.",
        dateVo = null,
    )

    val vo = ProfileDataVo(
        name = "User",
        surname = "User",
        dateOfBirth = dateOfBirthVo,
        weight = "127",
        height = "189",
        bloodType = BloodType.AB_MINUS,
    )
    
    ProfileSuccessView(
        vo = vo,
        onProfileInput = {},
    )
}