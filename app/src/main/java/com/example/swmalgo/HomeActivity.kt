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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swmalgo.ui.theme.SwMalgoTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwMalgoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeSplashScreen()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomeSplashScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
          modifier = Modifier
              .fillMaxWidth()
              .padding(top = 79.dp, start = 30.dp, end = 30.dp)
        ){
            Text(
                text = "OOO님 반가워요!"
            )

            Box(
                Modifier.weight(1f)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_reading_glasses),
                contentDescription = null,
                contentScale = ContentScale.Fit, // ScaleType
                modifier = Modifier
                    .size(width = 35.dp, height = 35.dp)
            )
        }

        Box(    // 베너
            modifier = Modifier
                .padding(top = 19.dp)
                .fillMaxWidth()
                .height(140.dp)
                .background(Color.Red)
        )

        Column (
            modifier = Modifier
            .padding(top = 50.dp, start = 30.dp, end = 30.dp)
        ){

        }






    }
}