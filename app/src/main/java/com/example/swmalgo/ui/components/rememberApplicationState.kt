package com.example.swmalgo.ui.components

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.swmalgo.domain.model.ApplicationState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberApplicationState(
    bottomBarState: MutableState<Boolean> = mutableStateOf(true),
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    uiController: SystemUiController = rememberSystemUiController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) = remember(Unit) {
    ApplicationState(
        bottomBarState = bottomBarState,
        navController = navController,
        uiController = uiController,
        scaffoldState = scaffoldState,
        coroutineScope = coroutineScope,
    )
}