package com.example.swmalgo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.swmalgo.ui.theme.SwMalgoTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwMalgoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LoginSplashScreen(context = this)
                }
            }
        }
    }
}

@Composable
fun LoginSplashScreen(modifier: Modifier = Modifier, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "로그인",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 30.dp,top = 112.dp)
        )

        Text(
            text = "회사 이메일을 적어주세요",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 30.dp, top = 63.dp)
        )

        Box(    // 회사 이메일
            modifier = Modifier
                .padding(start = 30.dp, top = 27.dp)
                .width(330.dp)
                .height(69.dp)
                .background(Color.LightGray)

        ){}

        Box(    // 회사 비밀번호
            modifier = Modifier
                .padding(start = 30.dp, top = 40.dp)
                .width(330.dp)
                .height(69.dp)
                .background(Color.LightGray)

        ){}

        Box(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(bottom = 100.dp)
                .wrapContentSize()
                .fillMaxWidth()

        ) {
            Box(    // 로그인 버튼
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(243.dp)
                    .height(55.dp)
                    .background(Color.Blue)
                    .clickable {
                        val nextIntent = Intent(context, KeywordSelectionActivity::class.java)
                        ContextCompat.startActivity(context, nextIntent, null)
                    }
            )

            Text(
                text = "회원가입/비밀번호 찾기",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 43.dp),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontSize = 15.sp,
            )
        }
    }

}