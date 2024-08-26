package com.example.petcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.data.CategoryListData
import com.example.petcare.data.getCategoryList
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.screen.common.AddPetDetailsBottomSheet
import com.example.petcare.ui.screen.common.SelectSpecialityBottomSheet
import com.example.petcare.ui.theme.Yellow
import kotlinx.coroutines.delay

@Preview
@Composable
private fun SearchPreview() {
    Search(navController = NavHostController(LocalContext.current))
}

@Composable
fun Search(navController: NavHostController) {

    val isAddPetSheetVisible = remember { mutableStateOf(false) }
    val isSelectSpecialitySheetVisible = remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        delay(500)
        isAddPetSheetVisible.value = true
    }

    //SelectSpecialityBottomSheet
    SelectSpecialityBottomSheet(
        isSelectSpecialitySheetVisible.value,
        onDismissRequest = { isSelectSpecialitySheetVisible.value = false },
        onSpecialityChoose = {
            navController.navigate(MainScreens.SpecialitiesAndClinics.route)
        }
    )

    //AddPetDetailsBottomSheet
    AddPetDetailsBottomSheet(
        isSheetVisible = isAddPetSheetVisible.value,
        onDismissRequest = { isAddPetSheetVisible.value = false },
        addPetClicked = {
            isAddPetSheetVisible.value = false
            navController.navigate(MainScreens.AddPetDetails.route)
        },
        noLaterClicked = { isAddPetSheetVisible.value = false }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {

        Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
            MultipleColorsInText()

            Spacer(modifier = Modifier.padding(10.dp))

            LazyVerticalGrid(columns = GridCells.Fixed(3), contentPadding = PaddingValues(5.dp)) {
                items(getCategoryList()) { item ->
                    ListItem(data = item) {
                        isSelectSpecialitySheetVisible.value = !isSelectSpecialitySheetVisible.value
                    }
                }
            }
        }

    }
}

@Composable
fun MultipleColorsInText() {
    Text(
        text =
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("What are you\nlooking for, ")
            }
            withStyle(style = SpanStyle(color = Yellow)) {
                append("Maria?")
            }
        },
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 15.dp)
    )
}

@Composable
fun ListItem(data: CategoryListData, onclick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .aspectRatio(1f),
        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .clickable { onclick.invoke() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = data.image),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )

            Spacer(modifier = Modifier.padding(2.dp))

            Text(text = data.category, color = Color.Black, fontWeight = FontWeight.SemiBold)
        }
    }
}