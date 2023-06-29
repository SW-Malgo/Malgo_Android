package com.example.swmalgo.ui.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.login.LoginScreen
import com.example.swmalgo.utils.Constants.LOGIN_GRAPH


fun NavGraphBuilder.loginGraph(
    appState: ApplicationState,
) {
    navigation(startDestination = LOGIN_GRAPH, route = LOGIN_GRAPH) {
        composable(LOGIN_GRAPH) { entry ->
            LoginScreen()
        }
    }
}