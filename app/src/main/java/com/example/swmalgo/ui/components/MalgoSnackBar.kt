package com.example.swmalgo.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MalgoSnackBar(message:String) {
    Snackbar(
        modifier = Modifier.padding(
            bottom = 50.dp,
            start = 20.dp,
            end = 20.dp
        )
    ) {
        Text(text = message)
    }
}