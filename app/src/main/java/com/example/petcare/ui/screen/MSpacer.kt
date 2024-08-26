package com.example.petcare.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MSpacer(paddingInDp: Int) {
    Spacer(modifier = Modifier.padding(paddingInDp.dp))
}