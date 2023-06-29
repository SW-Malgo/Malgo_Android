package com.example.swmalgo.ui.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmalgo.R

@Preview(showBackground = true)
@Composable
fun GroupScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 79.dp, start = 30.dp, end = 30.dp)
        ) {
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 30.dp, end = 30.dp)
        ) {
            Text(
                text = "모든 모임",
                fontSize = 20.sp

            )

            Box(
                Modifier.weight(1f)
            )

            Text(
                text = "정렬",
                fontSize = 20.sp
            )
        }



        LazyVerticalGrid(
            modifier = Modifier
                .padding(top = 8.dp, start = 30.dp, end = 11.dp),
            columns = GridCells.Fixed(2),
            content = {
                items(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) {
                    Box(
                        modifier = Modifier
                            .width(155.dp)
                            .height(155.dp)
                            .padding(end = 19.dp, bottom = 31.dp)
                            .border(1.dp, Color.Black)
                    ) {
                        Text(text = it.toString())
                    }
                }

            })
    }
}