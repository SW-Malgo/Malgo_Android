package com.example.swmalgo.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.CustomTextField
import com.example.swmalgo.ui.signup.SignUpViewModel.Companion.passWordRegex
import com.example.swmalgo.ui.theme.Gray300
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.utils.Constants.SIGNUP_KEYWORD_ROUTE

@Composable
fun SignUpPasswordScreen(appState: ApplicationState, viewModel: SignUpViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var passwordVaild by remember {
        mutableStateOf(true)
    }
    var retryPasswordVaild by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = uiState.password) {
        passwordVaild = if (uiState.password.isBlank()) {
            false
        } else {
            !(passWordRegex.matches(uiState.password))
        }
    }
    LaunchedEffect(key1 = uiState.passwordCheck) {
        retryPasswordVaild = if (uiState.passwordCheck.isBlank()) {
            false
        } else {
            !(uiState.passwordCheck == uiState.password)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MAIN_BACKGROUND)
                .weight(1f)
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "회원가입",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 60.dp),
                color = Color.White
            )

            Text(
                text = "비밀번호를 입력해 주세요.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 70.dp)
            )

            CustomTextField(
                value = uiState.password,
                onvalueChanged = viewModel::updatePassword,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .height(69.dp),
                placeholderText = "비밀번호",
                onErrorState = passwordVaild,
                errorMessage = "숫자, 영어, 특수문자를 포함해 8~15글자여야 합니다.",
                visibleTransform = PasswordVisualTransformation()
            )

            CustomTextField(
                value = uiState.passwordCheck,
                onvalueChanged = viewModel::updatePasswordCheck,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .height(69.dp),
                placeholderText = "비밀번호 확인",
                onErrorState = retryPasswordVaild,
                errorMessage = "비밀번호가 다릅니다.",
                keyboardActions = KeyboardActions(onDone = {
                    if (!passwordVaild) {
                        appState.navController.navigate(SIGNUP_KEYWORD_ROUTE)
                    }
                }),
                visibleTransform = PasswordVisualTransformation()
            )

            Box(modifier = Modifier.weight(1f))
        }

        val enable =
            uiState.password.isNotBlank() && uiState.passwordCheck.isNotBlank() && !passwordVaild && !retryPasswordVaild

        Button(
            onClick = {
                appState.navController.navigate(SIGNUP_KEYWORD_ROUTE)
            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(if (enable) POINT else Gray300)
        ) {
            Text(
                text = "회원 가입",
                color = MAIN_BACKGROUND,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(3.dp)
            )
        }
    }

}