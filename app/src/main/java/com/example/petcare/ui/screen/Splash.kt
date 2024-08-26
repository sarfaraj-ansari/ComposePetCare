package com.example.petcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.AuthScreens
import com.example.petcare.ui.theme.BlueViolet
import kotlinx.coroutines.delay

@Preview
@Composable
private fun SplashPreview() {
    Splash(navController = NavHostController(LocalContext.current))
}
@Composable
fun Splash(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        delay(500)
        navController.navigate(AuthScreens.Welcome.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.background_violet_gradient),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }
}