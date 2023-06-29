package com.example.swmalgo.ui.splash

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
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
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.utils.Constants.MAIN_GRAPH
import com.example.swmalgo.utils.Constants.SPLASH_ROUTE
import kotlinx.coroutines.delay


@Preview(showBackground = true)
@Composable
fun SplashScreen(
    appState: ApplicationState = rememberApplicationState()
) {

    LaunchedEffect(key1 = Unit) {
        delay(1000L)
        appState.navController.navigate(MAIN_GRAPH) {
            popUpTo(SPLASH_ROUTE) {
                inclusive = true
            }
        }
    }
    appState.uiController.setStatusBarColor(MAIN_BACKGROUND)
    appState.uiController.setSystemBarsColor(MAIN_BACKGROUND)
    Image(
        painter = painterResource(id = R.drawable.splacsh_screen),
        contentDescription = null,
        contentScale = ContentScale.Crop, // ScaleType
        modifier = Modifier
            .fillMaxSize()
    )

    Box(
        modifier = Modifier
            .background(Color(0xcc000000))
            .fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = PURE_WHITE)) {
                    append("업무 말고(MALGO) 취미생활")
                }
            },
//            style = TextStyle(lineHeight = 1.5.em),
            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 380.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = POINT)) {
                    append("Malgo!")
                }
            },
            fontSize = 85.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 12.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xffffffff))) {
                    append("공통 ")
                }
                withStyle(style = SpanStyle(color = Color(0xff00ff4e))) {
                    append("관심사")
                }
                withStyle(style = SpanStyle(color = Color(0xffffffff))) {
                    append("와 ")
                }
                withStyle(style = SpanStyle(color = Color(0xff00ff4e))) {
                    append("취미")
                }
                withStyle(style = SpanStyle(color = Color(0xffffffff))) {
                    append("를 통한\n")
                }
                withStyle(style = SpanStyle(color = Color(0xff00ff4e))) {
                    append("동료 ")
                }
                withStyle(style = SpanStyle(color = Color(0xffffffff))) {
                    append("연결 플랫폼, 말고!")
                }
            },
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 54.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = PURE_WHITE)) {
                    append("#음악 #운동 #스터디 #특강 #봉사")
                }
            },
//            style = TextStyle(lineHeight = 1.5.em),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 28.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = PURE_WHITE)) {
                    append("관심사가 같은 동료를 만나보세요")
                }
            },
//            style = TextStyle(lineHeight = 1.5.em),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 87.dp)
        )

    }
}
