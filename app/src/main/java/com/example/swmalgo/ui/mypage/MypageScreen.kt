@file:OptIn(ExperimentalGlideComposeApi::class, ExperimentalGlideComposeApi::class)

package com.example.swmalgo.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.swmalgo.ui.theme.Gray300
import com.example.swmalgo.ui.theme.Gray50
import com.example.swmalgo.ui.theme.Gray500
import com.example.swmalgo.ui.theme.Gray800
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.ui.theme.White800
import com.example.swmalgo.utils.Constants.MY_GROUP
import com.example.swmalgo.utils.Constants.USER_NUMBER

@Composable
@Preview
fun MypageScreen() {

    val itemList: List<List<String>> = listOf(
        listOf("음악을 사랑하는 모임", "#음악 #듣기 #즐겨요"),
        listOf("코딩을 사랑하는 모임", "#AI #배움 #성장"),
        listOf("운동을 사랑하는 모임", "#운동 #건강 #활기찬")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ) {
        Box(
            modifier = Modifier
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .padding(20.dp),
                tint = Color.White
            )

            GlideImage(
                model = R.drawable.img_mypage_temp,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.4f),
                contentScale = ContentScale.Crop
            )
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.8f)
                )
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
                        .background(MAIN_BACKGROUND)
                        .padding(horizontal = 30.dp, vertical = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${USER_NUMBER}번째 말고님",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "편집",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                    Text(
                        text = "#팀장 #배드민턴 #말고!", color = Color.White, fontSize = 12.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text(
                        text = "내가 보유한 동아리", color = Color.White, fontSize = 14.sp,
                        modifier = Modifier.padding(top = 40.dp)
                    )
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .background(Gray800)
                )
            }
        }


        LazyVerticalGrid(
            modifier = Modifier
                .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 70.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            content = {
                items(MY_GROUP) { group ->

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.2f)
                        ) {

                            GlideImage(
                                model = group.images.firstOrNull(),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )

                            if (group.tags.contains("운동")) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_king),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(5.dp)
                                        .size(24.dp)
                                )
                            }
                        }

                        Column(
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(top = 10.dp)
                        ) {
                            Text(
                                text = group.title,
                                color = PURE_WHITE,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )

                            Text(
                                text = group.tags,
                                color = PURE_WHITE,
                                fontSize = 10.sp,
                                modifier = Modifier
                                    .padding(top = 3.dp)
                            )
                        }
                    }
                }
            }
        )

    }
}