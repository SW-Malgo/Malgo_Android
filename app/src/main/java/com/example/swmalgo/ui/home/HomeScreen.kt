package com.example.swmalgo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.PURE_WHITE

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 79.dp, start = 30.dp, end = 30.dp)
            ) {
                Text(
                    text = "5382번째 말고님, 환영해요!",
                    color = PURE_WHITE,
                    fontSize = 15.sp
                )

                Box(
                    Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_reading_glasses),
                    contentDescription = null,
                    contentScale = ContentScale.Fit, // ScaleType
                    modifier = Modifier
                        .size(width = 20.dp, height = 20.dp)
                )
            }

            Box(    // 베너
                modifier = Modifier
                    .padding(top = 19.dp)
                    .fillMaxWidth()
                    .height(235.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.temp_img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xcc000000))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    {

                        Text(
                            text = "SAMSUNG & Malco!",
                            color = PURE_WHITE,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 30.dp, top = 70.dp)
                        )
                        Text(
                            text = "공통 관심사와 취미를 통한 동료 연결 플랫폼\n" + "삼성과 말코가 함께 합니다!",
                            color = PURE_WHITE,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(start = 30.dp, top = 12.dp)
                        )
                    }
                }
            }



            Column(
                modifier = Modifier
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp)
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "#코딩 #음악 #운동 모임",
                        color = PURE_WHITE,
                        fontSize = 18.sp
                    )

                    Box(Modifier.weight(1f))

                    Text(
                        text = "더보기",
                        color = PURE_WHITE,
                        fontSize = 11.sp,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                }
            }

            LazyRow(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                item {
                    Spacer(modifier = Modifier.width(30.dp))
                }

                val itemList: List<List<String>> = listOf(
                    listOf("음악을 사랑하는 모임", "#음악 #듣기 #즐겨요",),
                    listOf("코딩을 사랑하는 모임", "#AI #배움 #성장",),
                    listOf("운동을 사랑하는 모임", "#운동 #건강 #활기찬")
                )

                items(itemList) { item ->
                    val title = item[0]
                    val hashtags = item[1]
                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(149.dp)
                                .height(116.dp)
                                .padding(end = 17.dp)
                                .border(1.dp, Color.Black)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.temp_img),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                        Text(
                            text = title.toString(),
                            color = PURE_WHITE,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )

                        Text(
                            text = hashtags.toString(),
                            color = PURE_WHITE,
                            fontSize = 6.sp,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }
            }



            Column(
                modifier = Modifier
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp)
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "#코딩 #음악 #운동 모임",
                        color = PURE_WHITE,
                        fontSize = 18.sp
                    )

                    Box(Modifier.weight(1f))

                    Text(
                        text = "더보기",
                        color = PURE_WHITE,
                        fontSize = 11.sp,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                }
            }

            LazyRow(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                item {
                    Spacer(modifier = Modifier.width(30.dp))
                }

                val itemList: List<List<String>> = listOf(
                    listOf("음악을 사랑하는 모임", "#음악 #듣기 #즐겨요",),
                    listOf("코딩을 사랑하는 모임", "#AI #배움 #성장",),
                    listOf("운동을 사랑하는 모임", "#운동 #건강 #활기찬")
                )

                items(itemList) { item ->
                    val title = item[0]
                    val hashtags = item[1]
                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(149.dp)
                                .height(116.dp)
                                .padding(end = 17.dp)
                                .border(1.dp, Color.Black)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.temp_img),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                        Text(
                            text = title.toString(),
                            color = PURE_WHITE,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )

                        Text(
                            text = hashtags.toString(),
                            color = PURE_WHITE,
                            fontSize = 6.sp,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }
            }
        }

        FloatingActionButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 139.dp, end = 30.dp),
            shape = CircleShape,
            containerColor = Color.Unspecified,
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus_btn),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 35.dp, height = 35.dp),
                    tint = Color.Unspecified
                )
            }
        )
    }
}