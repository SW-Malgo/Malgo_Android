@file:OptIn(ExperimentalGlideComposeApi::class)

package com.example.swmalgo.ui.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.utils.Constants.MY_INTERESTED_GROUP
import com.example.swmalgo.utils.Constants.NOT_INTERTESTED_GROUP
import com.example.swmalgo.utils.Constants.UPLOAD_GROUP_ROUTE

@Composable
fun GroupScreen(
    appState: ApplicationState
) {

    val itemList: List<List<String>> = listOf(
        listOf("말고(malgo!)", "#업무 #말고 #취미생활"),
        listOf("맛집탐방", "#먹고 #사는 #문제"),
        listOf("독서와 글쓰기", "#독서 #글쓰기 #활동"),
        listOf("배드민턴 동아리", "#배드민턴 #치면서 #친해져요"),
        listOf("한강과 자전거", "#한강에서 #자전거 #낭만그잡채"),
        listOf("커피가 좋아", "#커피 #커피 #탐방")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MAIN_BACKGROUND)
                .padding(bottom = 70.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(text = "모든 동아리", fontSize = 20.sp, color = PURE_WHITE)
                    Text(
                        text = "우리 회사 내에 모든 동아리를 볼 수 있어요",
                        modifier = Modifier.padding(top = 0.dp),
                        color = PURE_WHITE,
                        fontSize = 12.sp
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_reading_glasses),
                    contentDescription = null,
                    contentScale = ContentScale.Fit, // ScaleType
                    modifier = Modifier
                        .size(width = 20.dp, height = 22.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {

                Box(
                    Modifier.weight(1f)
                )

                Text(
                    text = "정렬",
                    fontSize = 14.sp,
                    color = PURE_WHITE,
                    modifier = Modifier,
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.Bottom)
                )
            }


            LazyVerticalGrid(
                modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp, end = 30.dp),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                content = {
                    items(
                        (MY_INTERESTED_GROUP + NOT_INTERTESTED_GROUP).shuffled()
                    ) { group ->

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            GlideImage(
                                model = group.images.firstOrNull(),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.2f)
                            )
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
        FloatingActionButton(onClick = {
            appState.navigate(UPLOAD_GROUP_ROUTE)
        },
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