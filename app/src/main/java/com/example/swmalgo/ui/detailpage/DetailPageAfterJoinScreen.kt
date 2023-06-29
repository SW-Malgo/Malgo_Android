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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Preview(showBackground = true)
@Composable
fun DetailPageAfterJoinScreen() {

    var curCategory by remember {
        mutableStateOf<Int>(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ){
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
                    .height(170.dp)
                    .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
                    .background(MAIN_BACKGROUND)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
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
                                .background(MAIN_BACKGROUND)
                                .border(
                                    width = 1.dp,
                                    color = POINT
                                )

                        ) {
                            Text(
                                text = "가입하기",
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                color = POINT,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 27.dp, start = 30.dp, end = 30.dp),
                    ){
                        Text(
                            text = "게시글",
                            color = PURE_WHITE,
                            modifier = Modifier
                                .padding(top = 11.dp, start = 30.dp)
                                .clickable {
                                    curCategory = 0
                                }
                        )

                        Box(
                            Modifier.weight(1f)
                        )

                        Text(
                            text = "채팅방",
                            color = PURE_WHITE,
                            modifier = Modifier
                                .padding(top = 11.dp, end = 30.dp)
                                .clickable {
                                    curCategory = 1
                                }
                        )
                    }


                }
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0Xff792e4f), Color(0Xffa03f6a), Color(0Xff792e4f))
                )
            )
        )

        if(curCategory ==0){
            GroupArticles()
        }else{
            GroupChat()
        }
    }
}

@Composable
fun GroupChat() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
    ) {
        Box(
            Modifier.weight(1f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 15.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(41.dp)
                    .clip(RoundedCornerShape(80))
                    .background(PURE_WHITE)
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 5.dp)
            ) {
                Text(
                    text = "말고3",
                    color = PURE_WHITE,
                    fontSize = 12.sp
                )

                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = POINT,
                            shape = RoundedCornerShape(20),
                        )
                        .wrapContentWidth()
                        .height(32.dp),
                ){
                    Text (
                        text = "네 이따가 저녁도 먹으면 좋을 것 같아요",
                        color = PURE_WHITE,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(horizontal = 10.dp)
                    )
                }
            }
            Text (
                text = "오전 11:13",
                color = PURE_WHITE,
                fontSize = 6.sp,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(start = 5.dp)
            )
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 15.dp)
                .padding(end = 10.dp)
        ) {

            Box(
                Modifier.weight(1f)
            )

            Text (
                text = "오전 12:03",
                color = PURE_WHITE,
                fontSize = 6.sp,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(end = 5.dp)
            )
            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = POINT,
                        shape = RoundedCornerShape(20),
                    )
                    .wrapContentWidth()
                    .height(32.dp)
            ){
                Text (
                    text = "네 이따 뵐게요\uD83D\uDE01",
                    color = PURE_WHITE,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 10.dp)
                )
            }

        }









        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 6.dp)
        ) {
            Text (
                text = "메시지를 입력하세요",
                color = PURE_WHITE,
                fontSize = 12.sp
            )

            Box(
                Modifier.weight(1f)
            )

            Text (
                text = "전송",
                color = PURE_WHITE,
                fontSize = 12.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(PURE_WHITE)
        )
    }
}

@Composable
private fun GroupArticles() {
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
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(80))
                            .background(PURE_WHITE)
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

