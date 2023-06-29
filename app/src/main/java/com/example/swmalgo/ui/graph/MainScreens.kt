package com.example.swmalgo.ui.graph

import androidx.annotation.DrawableRes
import com.example.swmalgo.utils.Constants.GROUP_ROUTE
import com.example.swmalgo.utils.Constants.HOME_ROUTE
import com.example.swmalgo.utils.Constants.MYPAGE_ROUTE

enum class MainScreens(
    val route: String,
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
) {
    HOME(
        route = HOME_ROUTE,
        title = "홈",
        selectedIcon = 0, // 아이콘 넣기
        unselectedIcon = 0,
    ),
    GROUP(
        route = GROUP_ROUTE,
        title = "그룹",
        selectedIcon = 0,
        unselectedIcon = 0,
    ),
    MYPAGE(
        route = MYPAGE_ROUTE,
        title = "마이페이지",
        selectedIcon = 0,
        unselectedIcon = 0,
    );
}