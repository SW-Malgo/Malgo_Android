package com.example.swmalgo.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.CustomTextField
import com.example.swmalgo.ui.theme.Gray300
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.utils.Constants.SIGNUP_PASSWORD_ROUTE

@Composable
fun SignUpEmailVerifyScreen(appState: ApplicationState, viewModel: SignUpViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MAIN_BACKGROUND)
                .imePadding()
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
                text = "인증번호가 전송되었어요.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 70.dp)
            )

            CustomTextField(
                value = uiState.validateCode,
                onvalueChanged = {
                    if (it.length < 7) {
                        viewModel.updateValidateCode(it)
                    }
                },
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .height(69.dp),
                placeholderText = "인증 번호",
                keyboardActions = KeyboardActions(onDone = {
                    appState.navigate(SIGNUP_PASSWORD_ROUTE)
                })
            )

            Box(modifier = Modifier.weight(1f))
        }

        val enable = uiState.validateCode.length == 6
        Button(
            onClick = {
                appState.navigate(SIGNUP_PASSWORD_ROUTE)
            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(if (enable) POINT else Gray300)
        ) {
            Text(
                text = "이메일 인증",
                color = MAIN_BACKGROUND,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(3.dp)
            )
        }
    }

}