package com.example.swmalgo.ui.signup

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
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
import androidx.compose.runtime.LaunchedEffect
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
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.CustomTextField
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.utils.Constants.SIGNUP_EMAIL_VALIDATE_ROUTE


@Composable
fun SignUpEmailScreen(
    appState: ApplicationState
) {

    var email by remember {
        mutableStateOf("")
    }
    var emailValid by remember {
        mutableStateOf(isValidEmail(email))
    }

    LaunchedEffect(key1 = email) {
        emailValid = isValidEmail(email)
        Log.i("dlgocks1", emailValid.toString())
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .background(MAIN_BACKGROUND)
                .weight(1f)
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "환영합니다!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 60.dp),
                color = Color.White
            )

            Text(
                text = "회사 이메일을 적어주세요.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 70.dp)
            )
            CustomTextField(
                value = email,
                onvalueChanged = { email = it },
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .height(69.dp),
                placeholderText = "회사 이메일",
                onErrorState = !emailValid,
                errorMessage = "올바른 이메일을 입력해 주세요.",
                keyboardActions = KeyboardActions(onDone = {
                    if (emailValid) {
                        appState.navigate(SIGNUP_EMAIL_VALIDATE_ROUTE)
                    }
                })
            )

            Box(modifier = Modifier.weight(1f))


        }
        Button(
            onClick = {
                // 구현 X
                appState.navigate(SIGNUP_EMAIL_VALIDATE_ROUTE)
            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(POINT)
        ) {
            Text(
                text = "인증번호 전송",
                color = MAIN_BACKGROUND,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(3.dp)
            )
        }
    }

}

fun isValidEmail(target: CharSequence?): Boolean {
    return if (TextUtils.isEmpty(target)) {
        true
    } else {
        Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}