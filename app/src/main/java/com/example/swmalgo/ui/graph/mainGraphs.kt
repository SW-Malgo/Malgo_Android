package com.example.swmalgo.ui.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.group.GroupScreen
import com.example.swmalgo.ui.home.HomeScreen
import com.example.swmalgo.ui.mypage.MypageScreen
import com.example.swmalgo.utils.Constants.MAIN_GRAPH


fun NavGraphBuilder.mainGraph(
    appState: ApplicationState,
) {
    navigation(startDestination = MainScreens.HOME.route, route = MAIN_GRAPH) {
        composable(MainScreens.HOME.route) { entry ->
            HomeScreen()
        }
        composable(MainScreens.MYPAGE.route) { entry ->
            MypageScreen()
        }
        composable(MainScreens.GROUP.route) { entry ->
            GroupScreen()
        }

    }
}