package com.example.swmalgo.ui.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.signup.SignUpEmailVerifyScreen
import com.example.swmalgo.ui.signup.SignUpPasswordScreen
import com.example.swmalgo.ui.signup.SignUpScreen
import com.example.swmalgo.utils.Constants.SIGNUP_EMAIL_ROUTE
import com.example.swmalgo.utils.Constants.SIGNUP_EMAIL_VALIDATE_ROUTE
import com.example.swmalgo.utils.Constants.SIGNUP_GRAPH
import com.example.swmalgo.utils.Constants.SIGNUP_PASSWORD_ROUTE


fun NavGraphBuilder.signUpGraph(
    appState: ApplicationState,
) {

    navigation(startDestination = SIGNUP_EMAIL_ROUTE, route = SIGNUP_GRAPH) {
        composable(SIGNUP_EMAIL_ROUTE) {
            SignUpScreen(appState)
        }

        composable(SIGNUP_EMAIL_VALIDATE_ROUTE) {
            SignUpEmailVerifyScreen(appState)
        }

        composable(SIGNUP_PASSWORD_ROUTE) {
            SignUpPasswordScreen(appState)
        }
    }

}