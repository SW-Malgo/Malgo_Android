@file:OptIn(ExperimentalGlideComposeApi::class)

package com.example.swmalgo.ui.detailpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Icon
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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.theme.Gray600
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.utils.Constants.DETAIL_PAGE_AFTER_JOIN_ROUTE
import com.example.swmalgo.utils.Constants.profileImages

@Composable
fun DetailPageBeforeJoinScreen(
    appState: ApplicationState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            GlideImage(
                model = "https://previews.123rf.com/images/grynold/grynold1411/grynold141100016/33465791-%EA%B7%B8%EB%A3%B9-%EB%B0%8F-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EB%A1%9D-%EB%B0%B4%EB%93%9C%EC%9D%98-%EA%B0%80%EC%88%98.jpg",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
            )

            Box(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .fillMaxWidth()
                    .height(110.dp)
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
                            text = "슬기로운 삼성 생활",
                            color = PURE_WHITE,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )

                        Text(
                            text = "#밴드 #음악",
                            color = PURE_WHITE,
                            fontSize = 12.sp,
                        )

                        Text(
                            text = "21명 참여중",
                            color = PURE_WHITE,
                            fontSize = 12.sp,
                        )
                    }

                    Box(
                        Modifier.weight(1f)
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .width(128.dp)
                            .wrapContentHeight()
                            .background(POINT)
                    ) {
                        Text(
                            text = "가입하기",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(vertical = 5.dp)
                                .clickable {
                                    appState.showSnackbar("가입이 완료되었습니다.")
                                    appState.navController.navigate(DETAIL_PAGE_AFTER_JOIN_ROUTE) {
                                        popUpTo(DETAIL_PAGE_AFTER_JOIN_ROUTE) {
                                            inclusive = true
                                        }
                                    }
                                }
                        )
                    }
                }

            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            appState.popBackStack()
                        }
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Gray600)
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
                modifier = Modifier.padding(top = 20.dp, start = 30.dp)
            )

            LazyRow(
                modifier = Modifier
                    .padding(top = 20.dp, start = 30.dp, end = 30.dp)
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
                            text = "말고$it",
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
                    text = "삼성에서 밴드활동 하실분 모두 환영합니다",
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
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                    ) {
                        GlideImage(
                            model = "data:image/jpeg;base64,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",
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(156.dp)
                                .height(122.dp)
                        )

                        GlideImage(
                            model = "data:image/jpeg;base64,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",
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
                        GlideImage(
                            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSabNgVaWEqd-xEu4Ec4vJ-apTfYGI71TQLNQ&usqp=CAU",
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(156.dp)
                                .height(122.dp)
                        )

                        GlideImage(
                            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTl4azpnKfQYD8pvNldR0woR3CBcQ57yu9E4w&usqp=CAU",
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .width(156.dp)
                                .height(122.dp)
                        )
                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}