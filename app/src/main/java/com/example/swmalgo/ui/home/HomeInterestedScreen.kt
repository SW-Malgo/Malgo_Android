package com.example.swmalgo.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.White800
import com.example.swmalgo.utils.Constants
import com.example.swmalgo.utils.Constants.DETAIL_PAGE_BEFORE_JOIN_ROUTE
import com.google.accompanist.pager.HorizontalPagerIndicator

@Composable
fun HomeInterestedScreen(
    appState: ApplicationState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ) {
        Text(
            text = "뒤로가기",
            fontSize = 16.sp,
            color = White800,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp, bottom = 10.dp)
                .clickable {
                    appState.popBackStack()
                })
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#운동 #AI #음악",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
            Text(text = "자신의 관심사와 같은 동료를 만나보세요", fontSize = 12.sp, color = Color.White)
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {

            items(listOf("ㅇㅇ모임", "ㄴㄴ모임", "ㅎㅎ모임", "ㅁㅁ모임")) {
                InterrestedItemDetail(
                    it,
                    navigateToDetail = {
                        appState.navigate(DETAIL_PAGE_BEFORE_JOIN_ROUTE)
                    }
                )
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InterrestedItemDetail(
    title: String,
    navigateToDetail: () -> Unit
) {

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        3
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clickable {
                    navigateToDetail()
                }
        ) {
            HorizontalPager(state = pagerState) {
                Image(
                    painter = painterResource(id = R.drawable.splacsh_screen),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            HorizontalPagerIndicator(
                pagerState = pagerState, pageCount = 3,
                activeColor = Color.White,
                inactiveColor = Color.White.copy(alpha = 0.3f),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 30.dp, end = 30.dp)
        ) {
            Row {

                Column(modifier = Modifier.weight(3f)) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color.White
                    )
                    Text(text = "#음악 #듣기 #즐겨요", fontSize = 12.sp, color = Color.White)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(POINT),
                    shape = RectangleShape,
                    modifier = Modifier.weight(2f)
                ) {
                    Text(
                        text = "자세히 보기",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        color = MAIN_BACKGROUND
                    )
                }
            }
            Text(
                text = "모두 출근하실 때 우산 챙겨주시면 좋을 것 같아요!\n비가 너무 많이와 해커톤언제끝나지\n집에 가버리고싶군요",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}
