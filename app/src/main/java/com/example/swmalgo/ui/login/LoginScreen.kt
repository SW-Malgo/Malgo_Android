package com.example.swmalgo.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.SEARCH_BLUE

@Preview
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
            .padding(30.dp)
    ) {
        Text(
            text = "로그인",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 110.dp),
            color = Color.White
        )

        Text(
            text = "회사 이메일을 적어주세요",
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier
                .padding(top = 76.dp)
        )

        Box(    // 회사 이메일
            modifier = Modifier
                .padding(start = 30.dp, top = 27.dp)
                .width(330.dp)
                .height(69.dp)
                .background(Color.LightGray)

        ) {}

        Box(    // 회사 비밀번호
            modifier = Modifier
                .padding(start = 30.dp, top = 40.dp)
                .width(330.dp)
                .height(69.dp)
                .background(Color.LightGray)

        ) {}

        Box(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(bottom = 100.dp)
                .wrapContentSize()
                .fillMaxWidth()

        ) {
            Button(
                onClick = {
                    // TOOD
                    // 키워드 설정화면으로 이동
                },
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth(), colors = ButtonDefaults.buttonColors(POINT)
            ) {
                Text(
                    text = "로그인",
                    color = MAIN_BACKGROUND,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
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
                modifier = Modifier.align(Alignment.CenterHorizontally)
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