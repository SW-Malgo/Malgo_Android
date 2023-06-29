package com.example.swmalgo.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.utils.Constants.GROUP_ROUTE
import com.example.swmalgo.utils.Constants.HOME_ROUTE
import com.example.swmalgo.utils.Constants.MYPAGE_ROUTE

@Composable
fun ManageBottomBarState(
    navBackStackEntry: NavBackStackEntry?,
    applicationState: ApplicationState,
) {
    when (navBackStackEntry?.destination?.route) {
        GROUP_ROUTE, HOME_ROUTE, MYPAGE_ROUTE -> applicationState.bottomBarState.value = true
        else -> applicationState.bottomBarState.value = false
    }
}