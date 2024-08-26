package com.example.petcare.ui.navigation

sealed class MainScreens(val route: String) {
    data object Search: MainScreens("Search")
    data object Explore: MainScreens("Explore")
    data object Appointments: MainScreens("Appointments")
    data object Profile: MainScreens("ProfileTopBar")
    data object AddPetDetails: MainScreens("AddPetDetails")
    data object AddOwnerDetails: MainScreens("AddOwnerDetails")
    data object SpecialitiesAndClinics: MainScreens("SpecialitiesAndClinic")
    data object SpecialistDetails: MainScreens("SpecialistDetails")
    data object BookingConfirm: MainScreens("BookingConfirm")
    data object MyPets: MainScreens("MyPets")
}