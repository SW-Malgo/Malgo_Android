package com.example.swmalgo.ui.graph

import androidx.annotation.DrawableRes
import com.example.swmalgo.R
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
        selectedIcon = R.drawable.ic_fill_home_24, // 아이콘 넣기
        unselectedIcon = R.drawable.ic_baseline_home_24,
    ),
    GROUP(
        route = GROUP_ROUTE,
        title = "그룹",
        selectedIcon = R.drawable.ic_fill_search_24,
        unselectedIcon = R.drawable.ic_baseline_search_24,
    ),
    MYPAGE(
        route = MYPAGE_ROUTE,
        title = "마이페이지",
        selectedIcon = R.drawable.ic_fill_mypage_24,
        unselectedIcon = R.drawable.ic_baseline_mypage_24,
    );
}