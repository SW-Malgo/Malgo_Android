package com.example.swmalgo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.swmalgo.R

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
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
                text = "OOO님 반가워요!",
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
                    .size(width = 35.dp, height = 35.dp)
            )
        }

        Box(    // 베너
            modifier = Modifier
                .padding(top = 19.dp)
                .fillMaxWidth()
                .height(140.dp)
                .background(Color.Red)
        )



        Column(
            modifier = Modifier
                .padding(top = 50.dp, start = 30.dp, end = 30.dp)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Text(
                    text = "#코딩 #음악 #운동 모임",
                    fontSize = 21.sp,
                )

                Box(Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.ic_next_btn),
                    contentDescription = null,
                    contentScale = ContentScale.Fit, // ScaleType
                    modifier = Modifier
                        .size(width = 35.dp, height = 35.dp)
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
                items(listOf(1,2,3,4,5)){
                    Box(
                        modifier = Modifier
                            .width(149.dp)
                            .height(116.dp)
                            .padding(end = 17.dp)
                            .border(1.dp, Color.Black)
                    ){
                        Text(text = it.toString())
                    }

                }
            }






        Column(
            modifier = Modifier
                .padding(top = 50.dp, start = 30.dp, end = 30.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 36.dp)
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Text(
                    text = "이런 동아리는 어때요",
                    fontSize = 21.sp,
                )

                Box(Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.ic_next_btn),
                    contentDescription = null,
                    contentScale = ContentScale.Fit, // ScaleType
                    modifier = Modifier
                        .size(width = 35.dp, height = 35.dp)
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
                items(listOf(1,2,3,4,5)){
                    Box(
                        modifier = Modifier
                            .width(149.dp)
                            .height(116.dp)
                            .padding(end = 17.dp)
                            .border(1.dp, Color.Black)
                    ){
                        Text(text = it.toString())
                    }

                }
            }

        Box(    // 베너
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(79.dp)
                .background(Color.Red)
        )
    }
        
        FloatingActionButton(onClick = { /*TODO*/ },
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(bottom = 139.dp, end = 30.dp),
            shape = CircleShape,
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reading_glasses),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 35.dp, height = 35.dp)
                )
            }
        )
    }
}