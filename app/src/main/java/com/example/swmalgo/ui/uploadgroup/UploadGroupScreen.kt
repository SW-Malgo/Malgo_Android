@file:OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)

package com.example.swmalgo.ui.uploadgroup

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.CustomTextField
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.google.accompanist.pager.HorizontalPagerIndicator

@Composable
fun UploadGroupScreen(
    appState: ApplicationState
) {

    var name by remember {
        mutableStateOf("")
    }

    var tag by remember {
        mutableStateOf("")
    }

    var content by remember {
        mutableStateOf("")
    }

    var imageList by remember {
        mutableStateOf(listOf<Uri>())
    }

    var tagList by remember {
        mutableStateOf(listOf<String>())
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        imageList.size
    }

    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            // Handle the returned Uri
            uri?.let {
                imageList = imageList.toMutableList().apply {
                    add(uri)
                }
            }
        }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .background(MAIN_BACKGROUND)
    ) {

        Column(
            modifier = Modifier
                .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
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
                Text(
                    text = "동아리 만들기",
                    fontSize = 28.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 3.dp)
                )
            }
            Text(
                text = "나와 같은 관심사를 가진 동료를 찾아보세요!",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 30.dp)
        ) {
            if (imageList.isNotEmpty()) {
                Box {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.3f),
                        ) {

                            GlideImage(
                                model = imageList[it],
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentScale = ContentScale.Crop,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_delete_all_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(20.dp)
                                    .size(24.dp)
                                    .clickable {
                                        imageList = imageList
                                            .toMutableList()
                                            .apply {
                                                remove(imageList[it])
                                            }
                                    },
                                tint = Color.White
                            )
                        }

                    }

                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        pageCount = imageList.size,
                        activeColor = Color.White,
                        inactiveColor = Color.White.copy(alpha = 0.3f),
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 20.dp)
                    )


                }

            }

            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(1.dp, Color.White),
                onClick = {
                    galleryLauncher.launch("image/*")
                }
            ) {
                Text(
                    text = "사진 업로드",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }

            Column(
                modifier = Modifier.padding(horizontal = 30.dp)
            ) {

                CustomTextField(
                    value = name,
                    onvalueChanged = { name = it },
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth()
                        .height(69.dp),
                    placeholderText = "동아리 이름 작성"
                )

                CustomTextField(
                    value = tag,
                    onvalueChanged = { tag = it },
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(69.dp),
                    deleteButtonVisibe = false,
                    placeholderText = "태그(최소 1개 ~ 최대 3개)",
                    trailingIcon = {
                        Text(
                            text = "추가",
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.clickable {
                                tagList = tagList.toMutableList().apply {
                                    add("#$tag")
                                }
                                tag = ""
                            })
                    }
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    tagList.forEach {
                        Text(text = it, fontSize = 18.sp, color = Color.White)
                    }
                }

                CustomTextField(
                    value = content,
                    onvalueChanged = { content = it },
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    deleteButtonVisibe = false,
                    placeholderText = "동아리 소개",
                    singleLine = false,
                )

                Text(
                    text = "${name.length}/500",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }



        Button(
            onClick = {

            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(POINT)
        ) {
            Text(
                text = "동아리 만들기",
                color = MAIN_BACKGROUND,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(3.dp)
            )
        }


    }
}