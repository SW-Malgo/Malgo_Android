package com.example.swmalgo.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.CustomTextField
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.SEARCH_BLUE
import com.example.swmalgo.utils.Constants.LOGIN_GRAPH
import com.example.swmalgo.utils.Constants.MAIN_GRAPH
import com.example.swmalgo.utils.Constants.SIGNUP_GRAPH

@Composable
fun LoginScreen(appState: ApplicationState) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Image(
        painter = painterResource(id = R.drawable.splacsh_screen),
        contentDescription = null,
        contentScale = ContentScale.Crop, // ScaleType
        modifier = Modifier
            .fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND.copy(alpha = 0.9f))
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = "로그인",
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
                .padding(top = 110.dp)
        )

        CustomTextField(
            value = email,
            onvalueChanged = { email = it },
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .height(69.dp),
            placeholderText = "회사 이메일"
        )

        CustomTextField(
            value = password,
            onvalueChanged = { password = it },
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(69.dp),
            placeholderText = "비밀번호",
            visibleTransform = PasswordVisualTransformation()
        )

        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check_fill_20),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(20.dp)
            )
            Text(
                text = "자동 로그인",
                color = Color.White,
                modifier = Modifier.padding(start = 5.dp, bottom = 3.dp),
                fontSize = 14.sp
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_check_baseline_20),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(20.dp)
            )
            Text(
                text = "이메일 저장",
                color = Color.White,
                modifier = Modifier.padding(start = 5.dp, bottom = 3.dp),
                fontSize = 14.sp
            )
        }

        Box(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(bottom = 70.dp)
                .wrapContentSize()
                .fillMaxWidth()

        ) {
            Button(
                onClick = {
                    // 구현 X
                    appState.navController.navigate(MAIN_GRAPH) {
                        popUpTo(LOGIN_GRAPH) {
                            inclusive = true
                        }
                    }
                },
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth(), colors = ButtonDefaults.buttonColors(POINT)
            ) {
                Text(
                    text = "로그인",
                    color = MAIN_BACKGROUND,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(3.dp)
                )
            }

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("계정을 잊으셨나요? ")
                    }
                    withStyle(style = SpanStyle(color = SEARCH_BLUE)) {
                        append("ID 찾기")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append(" 또는 ")
                    }
                    withStyle(style = SpanStyle(color = SEARCH_BLUE)) {
                        append("비밀번호 찾기")
                    }
                },
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "아직 회원이 아닌가요?  ",
                fontSize = 15.sp,
                color = Color.White
            )

            Row(
                modifier = Modifier.clickable {
                    appState.navigate(SIGNUP_GRAPH)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "회원가입",
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontSize = 15.sp,
                    color = Color.White
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .height(15.dp)
                        .rotate(180f)
                        .padding(start = 0.dp)
                )
            }
        }
    }


}