package com.example.swmalgo.ui.detailpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.utils.Constants.profileImages

@Composable
fun DetailPageBeforeJoinScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 47.dp)
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.temp_img2),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(392.dp)
                    .height(260.dp)
            )
            Box(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .width(392.dp)
                    .height(113.dp)
                    .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
                    .background(MAIN_BACKGROUND)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        Text(
                            text = "최고의 음악 동아리",
                            color = PURE_WHITE,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 23.dp)
                        )

                        Text(
                            text = "#음악밴드 # 수상 # 즐거움",
                            color = PURE_WHITE,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )

                        Text(
                            text = "21명 참여중",
                            color = PURE_WHITE,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }

                    Box(
                        Modifier.weight(1f)
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 28.dp)
                            .width(128.dp)
                            .height(32.dp)
                            .background(POINT)

                    ) {
                        Text(
                            text = "가입하기",
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0Xff792e4f), Color(0Xffa03f6a), Color(0Xff792e4f))
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "참여자",
                color = PURE_WHITE,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp, start = 30.dp)
            )

            LazyRow(
                modifier = Modifier
                    .padding(top = 23.dp, start = 30.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(20) {
                    Column {
                        Image(
                            painter = painterResource(id = profileImages[it % 9]),
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(80))
                                .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape)
                        )

                        Text(
                            text = "말고" + it.toString(),
                            fontSize = 12.sp,
                            color = PURE_WHITE,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(top = 50.dp, start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(POINT)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "동아리 소개",
                        fontSize = 16.sp,
                        color = PURE_WHITE,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                }

                Text(
                    text = "동아리 소개",
                    fontSize = 12.sp,
                    color = PURE_WHITE,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 13.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 50.dp, start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(POINT)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "활동 사진",
                        fontSize = 16.sp,
                        color = PURE_WHITE,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )

                }


                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(top = 11.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.temp_img),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(156.dp)
                                .height(122.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.temp_img),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .width(156.dp)
                                .height(122.dp)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .padding(top = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.temp_img),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(156.dp)
                                .height(122.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.temp_img),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .width(156.dp)
                                .height(122.dp)
                        )
                    }

                }


                /*LazyHorizontalGrid(
                    modifier = Modifier
                        .padding(top = 11.dp, start = 30.dp, end = 30.dp),
                    rows = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    content = {
                        items(4) {
                            Image(
                                painter = painterResource(id = R.drawable.temp_img),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    }
                )*/


            }
        }
    }
}