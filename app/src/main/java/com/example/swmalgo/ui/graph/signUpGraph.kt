package com.example.swmalgo.ui.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.components.rememberNavControllerBackEntry
import com.example.swmalgo.ui.signup.SignUpEmailVerifyScreen
import com.example.swmalgo.ui.signup.SignUpPasswordScreen
import com.example.swmalgo.ui.signup.SignUpEmailScreen
import com.example.swmalgo.ui.signup.SignUpKeywordScreen
import com.example.swmalgo.utils.Constants.SIGNUP_EMAIL_ROUTE
import com.example.swmalgo.utils.Constants.SIGNUP_EMAIL_VALIDATE_ROUTE
import com.example.swmalgo.utils.Constants.SIGNUP_GRAPH
import com.example.swmalgo.utils.Constants.SIGNUP_KEYWORD_ROUTE
import com.example.swmalgo.utils.Constants.SIGNUP_PASSWORD_ROUTE


fun NavGraphBuilder.signUpGraph(
    appState: ApplicationState,
) {

    navigation(startDestination = SIGNUP_EMAIL_ROUTE, route = SIGNUP_GRAPH) {
        composable(SIGNUP_EMAIL_ROUTE) { entry ->
            val backStackEntry = rememberNavControllerBackEntry(
                entry = entry,
                appState = appState,
                graph = SIGNUP_GRAPH
            )
            SignUpEmailScreen(appState, hiltViewModel(backStackEntry))
        }

        composable(SIGNUP_EMAIL_VALIDATE_ROUTE) { entry ->
            val backStackEntry = rememberNavControllerBackEntry(
                entry = entry,
                appState = appState,
                graph = SIGNUP_GRAPH
            )
            SignUpEmailVerifyScreen(appState, hiltViewModel(backStackEntry))
        }

        composable(SIGNUP_PASSWORD_ROUTE) { entry ->
            val backStackEntry = rememberNavControllerBackEntry(
                entry = entry,
                appState = appState,
                graph = SIGNUP_GRAPH
            )
            SignUpPasswordScreen(appState, hiltViewModel(backStackEntry))
        }

        composable(SIGNUP_KEYWORD_ROUTE) { entry ->
            val backStackEntry = rememberNavControllerBackEntry(
                entry = entry,
                appState = appState,
                graph = SIGNUP_GRAPH
            )
            SignUpKeywordScreen(appState, hiltViewModel(backStackEntry))
        }
    }

}


