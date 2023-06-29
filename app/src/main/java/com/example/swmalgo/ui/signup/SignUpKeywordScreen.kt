package com.example.swmalgo.ui.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.rememberApplicationState
import com.example.swmalgo.ui.theme.Gray600
import com.example.swmalgo.ui.theme.Gray800
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.ui.theme.White800
import com.example.swmalgo.utils.Constants
import com.example.swmalgo.utils.Constants.MAIN_GRAPH
import com.example.swmalgo.utils.Constants.SIGNUP_GRAPH

@Composable
@Preview
fun SignUpKeywordScreen(
    appState: ApplicationState = rememberApplicationState()
) {
    Box(
        modifier = Modifier
            .background(MAIN_BACKGROUND)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = PURE_WHITE)) {
                        append("업무말고(MALGO) 취미생활")
                    }
                },
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(top = 100.dp)
            )

            Column {
                Text(
                    text = "관심사 키워드를",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Text(
                    text = "선택해주세요",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }


            Text(
                text = "최소 1개 ~ 최대 3개",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 15.dp),
                color = White800
            )

            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 40.dp),
            ) {
                Text(
                    text = "현재 핫한 모임",
                    color = Color.White,
                    fontSize = 19.sp
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_fire),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight, // ScaleType
                    modifier = Modifier
                        .size(width = 23.dp, height = 30.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .height(250.dp)
                    .verticalScroll(rememberScrollState())
                    .background(Gray600)
            ) {

            }
        }

        Button(
            onClick = {
                appState.navController.navigate(MAIN_GRAPH) {
                    popUpTo(SIGNUP_GRAPH) {
                        inclusive = true
                    }
                }
            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(POINT)
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