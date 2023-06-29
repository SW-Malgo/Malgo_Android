package com.example.swmalgo.ui.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.rememberApplicationState
import com.example.swmalgo.utils.Constants.MAIN_GRAPH
import com.example.swmalgo.utils.Constants.SPLASH_ROUTE
import kotlinx.coroutines.delay


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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp)
    ) {
        Text(
            text = "업무 말고(Malgo)\n취미생활",
            style = TextStyle(lineHeight = 1.5.em),
            fontSize = 39.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 182.dp)
        )

        Text(
            text = "#음악 #운동 #스터디 #특강 #봉사",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 37.dp)
        )

        Text(
            text = "관심사가 같은 동료를 만나보세요",
            fontSize = 23.sp,
            modifier = Modifier
                .padding(top = 37.dp)
        )
    }
}
