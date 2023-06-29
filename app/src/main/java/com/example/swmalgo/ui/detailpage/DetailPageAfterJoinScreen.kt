@file:OptIn(ExperimentalGlideComposeApi::class, ExperimentalGlideComposeApi::class)

package com.example.swmalgo.ui.detailpage

import android.graphics.Rect
import android.os.Build
import android.view.ViewTreeObserver
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.swmalgo.R
import com.example.swmalgo.domain.model.ChatMessage
import com.example.swmalgo.ui.MainActivity.Companion.databaseReference
import com.example.swmalgo.ui.components.CustomTextField
import com.example.swmalgo.ui.theme.Gray600
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import com.example.swmalgo.ui.theme.POINT
import com.example.swmalgo.ui.theme.PURE_WHITE
import com.example.swmalgo.utils.Constants
import com.example.swmalgo.utils.Constants.profileImages
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalGlideComposeApi::class)
@Preview(showBackground = true)
@Composable
fun DetailPageAfterJoinScreen() {

    var curCategory by remember {
        mutableStateOf<Int>(0)
    }
    val isKeyboardOpen by keyboardAsState() // true or false

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MAIN_BACKGROUND)
    ) {
        AnimatedVisibility(visible = isKeyboardOpen == Keyboard.Closed) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.temp_img2),
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
                                text = "슬기로운 삼성 생명",
                                color = PURE_WHITE,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 20.dp)
                            )

                            Text(
                                text = "#음악밴드 # 수상 # 즐거움",
                                color = PURE_WHITE,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(top = 0.dp)
                            )

                            Text(
                                text = "21명 참여중",
                                color = PURE_WHITE,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(top = 0.dp)
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
                                .border(BorderStroke(1.dp, POINT), RectangleShape)
                                .background(Color.Transparent)
                        ) {
                            Text(
                                text = "가입완료",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = POINT,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(vertical = 5.dp)
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

                            }
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = "게시물", fontSize = 12.sp, modifier = Modifier
                    .weight(1f)
                    .clickable {
                        curCategory = 0
                    },
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if (curCategory == 0) POINT else Color.Gray
            )
            Text(
                text = "채팅방", fontSize = 12.sp, modifier = Modifier
                    .weight(1f)
                    .clickable {
                        curCategory = 1
                    },
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if (curCategory == 1) POINT else Color.Gray
            )
        }

        Spacer(
            modifier = Modifier
                .height(5.dp)
                .fillMaxWidth()
                .background(Gray600)
        )

        if (curCategory == 0) {
            GroupArticles()
        } else {
            GroupChat()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GroupChat() {

    var sendingMessage by remember {
        mutableStateOf("")
    }
    val messages = remember {
        mutableStateListOf<ChatMessage>()
    }
    LaunchedEffect(key1 = Unit) {
        databaseReference?.addChildEventListener(object : ChildEventListener {

            // 새로운 자식이 추가 됬을 때
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                val chatMessage: ChatMessage =
                    dataSnapshot.getValue(ChatMessage::class.java) ?: return
                messages.add(chatMessage)
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
    ) {
        Box(
            Modifier.weight(1f)
        )

        messages.forEach {
            if (it.name == "Me") {
                MyMessage(it)
            } else {
                OpponentMessage(it)
            }
        }

        CustomTextField(
            value = sendingMessage,
            onvalueChanged = { sendingMessage = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(69.dp),
            placeholderText = "메시지를 입력하세요.", trailingIcon = {
                Text(
                    text = "전송",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable {
                        sendMessage(sendingMessage)
                        sendingMessage = ""
                    }
                )
            },
            deleteButtonVisibe = false
        )
    }
}

@Composable
private fun MyMessage(chatMessage: ChatMessage) {

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

        val inputDate = chatMessage.uploadDate ?: ""
        val formatter = DateTimeFormatter.ofPattern("MM/dd - HH시 mm분")
        val dateTime = LocalDateTime.parse(inputDate)
        val formattedDate = dateTime.format(formatter)
        Text(
            text = formattedDate,
            color = PURE_WHITE,
            fontSize = 7.sp,
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(end = 5.dp, bottom = 5.dp)
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
        ) {
            Text(
                text = chatMessage.message ?: "-",
                color = PURE_WHITE,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 10.dp)
            )
        }
    }
}

@Composable
private fun OpponentMessage(chatMessage: ChatMessage) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 15.dp)
    ) {
        Image(
            painter = painterResource(id = profileImages.random()),
            contentDescription = null,
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
                text = chatMessage.name ?: "익명의 말코",
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
            ) {
                Text(
                    text = chatMessage.message ?: "-",
                    color = PURE_WHITE,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 10.dp)
                )
            }
        }

        val inputDate = chatMessage.uploadDate ?: ""
        val formatter = DateTimeFormatter.ofPattern("MM/dd - HH시 mm분")
        val dateTime = LocalDateTime.parse(inputDate)
        val formattedDate = dateTime.format(formatter)
        Text(
            text = formattedDate,
            color = PURE_WHITE,
            fontSize = 6.sp,
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(start = 5.dp, bottom = 5.dp)

        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun sendMessage(text: String) {
    if (text.isNotBlank()) {
        val chatMessage = ChatMessage(
            message = text.trim(),
            name = "Me",
            uploadDate = LocalDateTime.now().toString()
        )
        databaseReference?.push()?.setValue(chatMessage)
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
                        painter = painterResource(id = Constants.profileImages[it % 9]),
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
        }
    }
}


enum class Keyboard {
    Opened, Closed
}

@Composable
fun keyboardAsState(): State<Keyboard> {
    val keyboardState = remember { mutableStateOf(Keyboard.Closed) }
    val view = LocalView.current
    DisposableEffect(view) {
        val onGlobalListener = ViewTreeObserver.OnGlobalLayoutListener {
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val screenHeight = view.rootView.height
            val keypadHeight = screenHeight - rect.bottom
            keyboardState.value = if (keypadHeight > screenHeight * 0.15) {
                Keyboard.Opened
            } else {
                Keyboard.Closed
            }
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(onGlobalListener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalListener)
        }
    }

    return keyboardState
}