package com.example.swmalgo.ui.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.rememberNavControllerBackEntry
import com.example.swmalgo.ui.detailpage.DetailPageAfterJoinScreen
import com.example.swmalgo.ui.detailpage.DetailPageBeforeJoinScreen
import com.example.swmalgo.ui.group.GroupScreen
import com.example.swmalgo.ui.home.HomeInterestedScreen
import com.example.swmalgo.ui.home.HomeScreen
import com.example.swmalgo.ui.mypage.MypageScreen
import com.example.swmalgo.ui.uploadgroup.UploadGroupScreen
import com.example.swmalgo.utils.Constants.DETAIL_PAGE_AFTER_JOIN_ROUTE
import com.example.swmalgo.utils.Constants.DETAIL_PAGE_BEFORE_JOIN_ROUTE
import com.example.swmalgo.utils.Constants.UPLOAD_GROUP_ROUTE
import com.example.swmalgo.utils.Constants.HOME_INTERESTED_ROUTE
import com.example.swmalgo.utils.Constants.MAIN_GRAPH


fun NavGraphBuilder.mainGraph(
    appState: ApplicationState,
) {
    navigation(startDestination = MainScreens.HOME.route, route = MAIN_GRAPH) {
        composable(MainScreens.HOME.route) {
            HomeScreen(appState)
        }
        composable(MainScreens.MYPAGE.route) { entry ->
            MypageScreen()
        }
        composable(MainScreens.GROUP.route) { entry ->
            GroupScreen(appState)
        }
        composable(HOME_INTERESTED_ROUTE) {
            HomeInterestedScreen(appState)
        }
        composable(UPLOAD_GROUP_ROUTE) {
            UploadGroupScreen(appState)
        }
        composable(DETAIL_PAGE_BEFORE_JOIN_ROUTE) {
            DetailPageBeforeJoinScreen(appState)
        }
        composable(DETAIL_PAGE_AFTER_JOIN_ROUTE) {
            DetailPageAfterJoinScreen(appState)
        }

    }
}