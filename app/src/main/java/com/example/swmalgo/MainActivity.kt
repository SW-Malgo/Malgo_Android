package com.example.swmalgo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.swmalgo.ui.theme.SwMalgoTheme
import androidx.compose.ui.text.TextStyle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val delayMillis: Long = 1000 // 1초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwMalgoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
        // 1초 뒤에 다음 액티비티로 이동
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, delayMillis)
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SwMalgoTheme {
        Greeting()
    }
}