package com.example.swmalgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.swmalgo.ui.theme.SwMalgoTheme

class KeywordSelectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwMalgoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    KeywordSplashScreen()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun KeywordSplashScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp)
    ) {
        Text(
            text = "직장인들의 은밀한 취미생활 malgo!",
            fontSize = 19.sp,
            modifier = Modifier
                .padding(top = 146.dp)
        )

        Text(
            text = "관심사 키워드를\n선택해주세요",
            style = TextStyle(lineHeight = 1.5.em),
            fontSize = 39.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 21.dp)
        )

        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 12.dp, top = 36.dp)
        ){
            Text(
                text = "현재 핫한 모임",
                fontSize = 21.sp,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_fire),
                contentDescription = null,
                contentScale = ContentScale.FillHeight, // ScaleType
                modifier = Modifier
                    .size(width = 21.dp, height = 25.dp)
                    .padding(top = 5.dp)
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

        Image(
            painter = painterResource(id = R.drawable.ic_next_btn),
            contentDescription = null,
            contentScale = ContentScale.Fit, // ScaleType
            modifier = Modifier
                .padding(start = 269.dp, bottom = 69.dp)
                .size(width = 55.dp, height = 55.dp)
        )
    }
}