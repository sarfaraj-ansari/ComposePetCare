package com.example.petcare.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.petcare.R
import com.example.petcare.ui.theme.Violet

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val items: Array<BottomNavData> = arrayOf(
        BottomNavData(MainScreens.Search, "Search", R.drawable.search),
        BottomNavData(MainScreens.Appointments, "Appointments", R.drawable.explore),
        BottomNavData(MainScreens.Explore, "Explore", R.drawable.explore),
        BottomNavData(MainScreens.Profile, "Profile", R.drawable.profile_icon)
    )
    BottomNavigation(backgroundColor = Color.White) {
        val navBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
        val currentRoute: String? = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = item.screens.route == currentRoute,
                selectedContentColor = Violet,
                unselectedContentColor = Color.Gray,
                onClick = {
                    navController.navigate(item.screens.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                label = { Text(text = item.label, fontSize = 10.sp) }

            )
        }
    }

}