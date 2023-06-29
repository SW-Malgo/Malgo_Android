package com.example.swmalgo.ui.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE

@Preview
@Composable
fun SignUpKeywordScreen() {
    Box(
        modifier = Modifier
            .background(MAIN_BACKGROUND)
            .fillMaxSize()
    ){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = PURE_WHITE)) {
                    append("직장인들의 은밀한 취미생활 malgo!")
                }
            },
            fontSize = 19.sp,
            modifier = Modifier
                .padding(top = 146.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = PURE_WHITE)) {
                    append("관심사 키워드를\n" +
                            "선택해주세요")
                }
            },
            fontSize = 39.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 21.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = PURE_WHITE)) {
                    append("최소 1개 ~ 최대 3개")
                }
            },
            fontSize = 10.sp,
            modifier = Modifier
                .padding(top = 20.dp)
        )

        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 12.dp, top = 36.dp)
        ){
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = PURE_WHITE)) {
                        append("현재 핫한 모임")
                    }
                },
                fontSize = 21.sp
            )
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
                .padding(top = 62.dp)
                .width(324.dp)
                .height(144.dp)
                .background(Color.LightGray)
        ){
            Text(
                text = "#~~~"
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
        )

        /*Image(
            painter = painterResource(id = R.drawable.ic_next_btn),
            contentDescription = null,
            contentScale = ContentScale.Fit, // ScaleType
            modifier = Modifier
                .padding(start = 269.dp, bottom = 69.dp)
                .size(width = 55.dp, height = 55.dp)
        )*/
    }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(POINT)
                .align(Alignment.BottomCenter)
        ){
            Text(
                text = "시작하기",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 17.dp, start = 160.dp)
            )
        }
    }
}