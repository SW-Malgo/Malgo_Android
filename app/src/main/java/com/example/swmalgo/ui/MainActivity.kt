package com.example.swmalgo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.swmalgo.ui.theme.SwMalgoTheme
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.swmalgo.ui.components.ManageBottomBarState
import com.example.swmalgo.ui.components.rememberApplicationState
import com.example.swmalgo.ui.components.RootNavHost
import com.example.swmalgo.ui.theme.MAIN_BACKGROUND
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwMalgoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background // App 메인 색으로 변경하기
                ) {
                    val appState = rememberApplicationState()
                    val navBackStackEntry by appState.navController.currentBackStackEntryAsState()
                    ManageBottomBarState(navBackStackEntry, appState)
                    RootNavHost(
                        navBackStackEntry = navBackStackEntry,
                        appState = appState,
                    )
                }
            }
        }
    }
}