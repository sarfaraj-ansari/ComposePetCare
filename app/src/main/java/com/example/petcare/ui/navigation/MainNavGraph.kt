package com.example.petcare.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petcare.R
import com.example.petcare.ui.screen.AddOwnerDetails
import com.example.petcare.ui.screen.AddPetDetails
import com.example.petcare.ui.screen.Appointments
import com.example.petcare.ui.screen.BookingConfirmation
import com.example.petcare.ui.screen.Search
import com.example.petcare.ui.screen.Explore
import com.example.petcare.ui.screen.MSpacer
import com.example.petcare.ui.screen.MyPets
import com.example.petcare.ui.screen.Profile
import com.example.petcare.ui.screen.SpecialistAndClinics
import com.example.petcare.ui.screen.SpecialistDetails
import kotlinx.coroutines.launch

@Preview
@Composable
fun MainNavGraph() {
    val navController: NavHostController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()

    val menuItems = listOf(
        MenuData(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home
        ),
        MenuData(
            title = "Edit",
            selectedIcon = Icons.Filled.Edit,
            unSelectedIcon = Icons.Outlined.Edit
        ),
        MenuData(
            title = "Favorite",
            selectedIcon = Icons.Filled.Favorite,
            unSelectedIcon = Icons.Outlined.Favorite
        ),
        MenuData(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.3f)
                        .background(color = Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Sarfaraj", color = Color.White, fontSize = 25.sp)
                }

                MSpacer(paddingInDp = 5)

                //Default menu items
                /*menuItems.forEachIndexed { index, menuData ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        label = { Text(text = menuData.title) },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) menuData.selectedIcon else menuData.unSelectedIcon,
                                contentDescription = null
                            )
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch { drawerState.close() }
                        }
                    )
                }*/

                //Custom menu items
                Column {

                    menuItems.forEachIndexed { index, menuData ->

                        MSpacer(paddingInDp = 3)

                        Row(
                            Modifier
                                .padding(start = 10.dp, end = 10.dp)
                                .height(50.dp)
                                .fillMaxWidth()
                                .background(
                                    color = if (selectedItemIndex == index) Color.Gray else Color.Transparent,
                                    shape = CircleShape
                                )
                                .pointerInput(Unit) {
                                    detectTapGestures(onPress = {
                                        selectedItemIndex = index
                                        scope.launch { drawerState.close() }
                                    })
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            MSpacer(paddingInDp = 10)

                            Icon(
                                imageVector = if (selectedItemIndex == index) menuData.selectedIcon else menuData.unSelectedIcon,
                                contentDescription = null
                            )

                            MSpacer(paddingInDp = 10)

                            Text(text = menuData.title, fontWeight = FontWeight.SemiBold)

                        }

                        MSpacer(paddingInDp = 3)

                    }

                }

            }
        }
    ) {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) },
            content = { innerPadding ->
                ConstraintLayout(modifier = Modifier.padding(innerPadding)) {

                    NavHost(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        startDestination = MainScreens.Search.route
                    ) {
                        composable(MainScreens.Search.route) {
                            Search(navController)
                        }
                        composable(MainScreens.Appointments.route) {
                            Appointments()
                        }
                        composable(MainScreens.Explore.route) {
                            Explore()
                        }
                        composable(MainScreens.Profile.route) {
                            Profile(navController)
                        }
                        composable(MainScreens.AddPetDetails.route) {
                            AddPetDetails(navController)
                        }
                        composable(MainScreens.AddOwnerDetails.route) {
                            AddOwnerDetails(navController)
                        }
                        composable(MainScreens.SpecialitiesAndClinics.route) {
                            SpecialistAndClinics(navController)
                        }
                        composable(MainScreens.SpecialistDetails.route) {
                            SpecialistDetails(navController)
                        }
                        composable(MainScreens.BookingConfirm.route) {
                            BookingConfirmation(navController)
                        }
                        composable(MainScreens.MyPets.route) {
                            MyPets(navController)
                        }
                    }

                    Button(onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                        Text(text = "Open Drawer", color = Color.White)
                    }
                }
            }
        )
    }
}

data class MenuData(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)