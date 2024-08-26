package com.example.petcare.ui.navigation

sealed class AuthScreens(val route: String) {
    data object Splash: AuthScreens("Splash")
    data object Welcome: AuthScreens("Welcome")
    data object SignUpMainScreen: AuthScreens("SignUpMainScreen")
    data object Register: AuthScreens("Register")
    data object SignIn: AuthScreens("SignIn")
}