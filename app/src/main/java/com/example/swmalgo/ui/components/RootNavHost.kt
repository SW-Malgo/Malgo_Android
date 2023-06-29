package com.example.swmalgo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.swmalgo.domain.model.ApplicationState
import com.example.swmalgo.ui.graph.loginGraph
import com.example.swmalgo.ui.graph.mainGraph
import com.example.swmalgo.ui.graph.signUpGraph
import com.example.swmalgo.ui.splash.SplashScreen
import com.example.swmalgo.utils.Constants.SPLASH_ROUTE

@Composable
fun RootNavHost(
    navBackStackEntry: NavBackStackEntry?,
    appState: ApplicationState,
) {
    Scaffold(
        scaffoldState = appState.scaffoldState,
        snackbarHost = {
            SnackbarHost(
                hostState = appState.scaffoldState.snackbarHostState,
                snackbar = { data ->
                    MalgoSnackBar(message = data.message)
                }
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavHost(
                appState.navController,
                startDestination = SPLASH_ROUTE,
                Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
            ) {
                mainGraph(appState)
                loginGraph(appState)
                signUpGraph(appState)
                composable(SPLASH_ROUTE) {
                    SplashScreen(appState)
                }
            }
            BottomBar(appState)
        }
    }
}