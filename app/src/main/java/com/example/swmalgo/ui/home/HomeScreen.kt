@file:OptIn(ExperimentalFoundationApi::class)

package com.example.swmalgo.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.rememberApplicationState
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.utils.Constants.HOME_INTERESTED_ROUTE
import com.google.accompanist.pager.HorizontalPagerIndicator

@Composable
fun HomeScreen(appState: ApplicationState = rememberApplicationState()) {

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        3
    }
    val itemList: List<List<String>> = listOf(
        listOf("음악을 사랑하는 모임", "#음악 #듣기 #즐겨요"),
        listOf("코딩을 사랑하는 모임", "#AI #배움 #성장"),
        listOf("운동을 사랑하는 모임", "#운동 #건강 #활기찬")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "5382번째 말고님, 환영해요!",
                    color = PURE_WHITE,
                    fontSize = 16.sp
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_reading_glasses),
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // ScaleType
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            Box(    // 베너
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.4f)
            ) {
                HorizontalPager(
                    state = pagerState,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xcc000000))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.temp_img),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                        // 좌에서 오른쪽 검정색, 투명색 그라디언트가 있는 박스
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .fillMaxHeight()
                                .align(Alignment.CenterStart)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0xFF000000),
                                            Color.Transparent
                                        ),
                                    )
                                )
                        )


                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 30.dp)
                        ) {
                            Text(
                                text = "SAMSUNG & Malco!",
                                color = PURE_WHITE,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 70.dp)
                            )
                            Text(
                                text = "공통 관심사와 취미를 통한 동료 연결 플랫폼\n" + "삼성과 말코가 함께 합니다!",
                                color = PURE_WHITE,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(top = 12.dp)
                            )
                        }
                    }
                }
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    pageCount = 3,
                    activeColor = Color.White,
                    inactiveColor = Color.White.copy(alpha = 0.3f),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp)
                )
            }

            HomeGroupeContainer(
                appState = appState,
                title = "#코딩 #음악 #운동 모임",
                itemList = itemList
            )

            HomeGroupeContainer(
                appState = appState,
                title = "이런 동아리는 어때요?",
                itemList = itemList
            )

            Spacer(modifier = Modifier.height(64.dp))
        }

        FloatingActionButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp)
                .padding(bottom = 64.dp),
            shape = CircleShape,
            containerColor = POINT,
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

@Composable
private fun HomeGroupeContainer(
    appState: ApplicationState,
    title: String,
    itemList: List<List<String>>
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp, start = 30.dp, end = 30.dp)
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = PURE_WHITE,
                fontSize = 18.sp
            )

            Text(
                text = "더보기",
                color = PURE_WHITE,
                fontSize = 11.sp,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .clickable { appState.navigate(HOME_INTERESTED_ROUTE) }
            )
        }
    }

    LazyRow(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        item {
            Spacer(modifier = Modifier.width(20.dp))
        }
        items(itemList) { item ->
            val title = item[0]
            val hashtags = item[1]
            Column(
                modifier = Modifier
                    .wrapContentSize()
            ) {
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(120.dp)
                        .padding(horizontal = 10.dp)
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
                    text = title,
                    color = PURE_WHITE,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp)
                )

                Text(
                    text = hashtags,
                    color = PURE_WHITE,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(top = 3.dp, start = 10.dp)
                )
            }
        }
    }
}