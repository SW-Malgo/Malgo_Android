package com.example.swmalgo.ui.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.rememberApplicationState
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.ui.theme.White800
import com.example.swmalgo.utils.Constants.MAIN_GRAPH
import com.example.swmalgo.utils.Constants.SIGNUP_GRAPH


@Composable
fun SignUpKeywordScreen(
    appState: ApplicationState = rememberApplicationState(),
    viewModel: SignUpViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .background(MAIN_BACKGROUND)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
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

            KeywordBox(
//                showSnackBar = {
//                    appState.showSnackbar("3")
//                }
            )
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

@Composable
@Preview
private fun KeywordBox() {
    val configuration = LocalConfiguration.current


    var keywordList by remember {
        mutableStateOf(listOf<String>())
    }

    Box(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .height(780.dp)
    ) {
        val itemList: List<List<Any>> = listOf(
            listOf(240, 85, 115, "#오픈소스", 16),
            listOf(0, 68, 165, "#AI", 38),
            listOf(132, 214, 115, "#부동산", 24),
            listOf(-17, 271, 137, "#밴드", 24),
            listOf(120, 407, 86, "#등산", 12),
            listOf(231, 290, 154, "#운동", 24),
            listOf(240, 466, 115, "#투자", 24),
            listOf(10, 508, 190, "#음악", 36),
            listOf(200, 609, 115, "#코딩", 20)
        )

        var index = 0
        itemList.forEach { item ->
            val sw = itemList[index][0] as Int
            val sh = itemList[index][1] as Int
            val cs = itemList[index][2] as Int
            val ht = itemList[index][3] as String
            val fs = itemList[index][4] as Int

            RoundCheckbox(sw, sh, cs, ht, fs,
                listSize = keywordList.size,
            onclick = { isChecked->
                if(isChecked){
                    keywordList = keywordList.toMutableList().apply {
                        add(ht)
                    }
                }else{
                    keywordList = keywordList.toMutableList().apply {
                        remove(ht)
                    }
                }

            }
            )
            index += 1
        }
    }
}
@Composable
fun RoundCheckbox(
    sw: Int,
    sh: Int,
    cs: Int,
    ht: String,
    fs: Int,
    onclick: (Boolean) -> Unit,
    listSize: Int
) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .offset(x = (sw).toInt().dp, y = (sh).toInt().dp)
            .size(cs.dp)
            .clip(RoundedCornerShape(80))
            .clickable {
                if (listSize > 3) {
                    if (isChecked) {
                        isChecked = !isChecked
                    } else{
                    }
                } else {
                    isChecked = !isChecked
                    onclick(isChecked)
                }
            }
            .background(if (isChecked) POINT.copy(alpha = 0.5f) else Color(0xff737373).copy(alpha = 0.5f))
    ) {
        Text(
            text = ht,
            fontSize = fs.sp,
            fontWeight = FontWeight.Bold,
            color = PURE_WHITE,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }


}
