package com.example.petcare.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petcare.ui.screen.Register
import com.example.petcare.ui.screen.SignIn
import com.example.petcare.ui.screen.SignUpMainScreen
import com.example.petcare.ui.screen.Splash
import com.example.petcare.ui.screen.Welcome

@Composable
fun NavGraph() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = AuthScreens.Splash.route, modifier = Modifier.fillMaxSize()) {
        composable(AuthScreens.Splash.route) {
            Splash(navController)
        }
        composable(AuthScreens.Welcome.route) {
            Welcome(navController)
        }
        composable(AuthScreens.SignUpMainScreen.route) {
            SignUpMainScreen(navController)
        }
        composable(AuthScreens.Register.route) {
            Register(navController)
        }
        composable(AuthScreens.SignIn.route) {
            SignIn(navController)
        }
    }
}