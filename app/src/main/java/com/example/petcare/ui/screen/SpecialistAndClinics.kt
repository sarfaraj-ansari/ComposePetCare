package com.example.petcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.data.getAllTherapistName
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.theme.Gray
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
fun SpecialistAndClinicsPreview() {
    SpecialistAndClinics(NavHostController(LocalContext.current))
}
@Composable
fun SpecialistAndClinics(navController: NavHostController) {

    var checkState: String by remember { mutableStateOf("specialist") }
    var searchText: String by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {

            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(start = 15.dp, end = 15.dp)) {

                MSpacer(paddingInDp = 5)

                Header(checkState = checkState, onCategoryChoose = { checkState = it })

                MSpacer(paddingInDp = 10)

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(color = Gray, shape = CircleShape), verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 15.dp)
                    )

                    BasicTextField(
                        modifier = Modifier.padding(start = 5.dp),
                        value = searchText,
                        onValueChange = { searchText = it },
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        decorationBox = { innerTextField ->
                            if(searchText == "") {
                                Text(text = "Search here...", color = Color.Black, fontSize = 15.sp, fontWeight = FontWeight.Normal)
                            }
                            innerTextField()
                        }
                    )

                }
            }

        }

        LazyColumn(Modifier.padding(top = 5.dp, bottom = 5.dp)) {

            items(getAllTherapistName().filter { it.contains(searchText, ignoreCase = true) }) { item ->
                ListItem(item) {
                    navController.navigate(MainScreens.SpecialistDetails.route)
                }
            }

        }

    }

}

@Composable
fun Header(checkState: String, onCategoryChoose: (String) -> Unit) {

    Column(
        modifier = Modifier
            .background(color = Color.White)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .height(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = null,
                modifier = Modifier.align(
                    Alignment.CenterStart
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(40.dp)
                    .align(Alignment.Center)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(width = 1.dp, color = Color.Gray, shape = CircleShape)
                )

                Row(modifier = Modifier.fillMaxSize()) {

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(
                                color = if (checkState == "specialist") Violet else Color.Transparent,
                                shape = CircleShape
                            )
                            //click without ripple effect
                            .pointerInput(Unit) {
                                detectTapGestures(onPress = {
                                    onCategoryChoose.invoke("specialist")
                                })
                            }, contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Specialists",
                            color = if (checkState == "specialist") Color.White else Color.Black
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(
                                color = if (checkState == "clinics") Violet else Color.Transparent,
                                shape = CircleShape
                            )
                            //click without ripple effect
                            .pointerInput(Unit) {
                                detectTapGestures(onPress = {
                                    onCategoryChoose.invoke("clinics")
                                })
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Clinics",
                            color = if (checkState == "clinics") Color.White else Color.Black
                        )
                    }

                }

            }
        }

    }

}

@Composable
fun ListItem(name: String, onIteClicked: () -> Unit) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(170.dp)
        .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
        .clickable { onIteClicked.invoke() },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp)
            .background(color = Color.White),
            verticalArrangement = Arrangement.Center
        ) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            ) {

                Image(painter = painterResource(id = R.drawable.profile_photo), contentDescription = null, modifier = Modifier
                    .size(90.dp)
                    .clip(shape = RoundedCornerShape(15.dp)))

                MSpacer(paddingInDp = 10)

                Column {

                    Text(text = name, fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)

                    MSpacer(paddingInDp = 3)

                    Text(text = "Veterinary Dentist", fontSize = 15.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)

                    MSpacer(paddingInDp = 5)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.rating), contentDescription = null)

                        Text(text = "125 Reviews")
                    }
                }

            }

            MSpacer(paddingInDp = 5)

            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "10", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 18.sp)

                Text(text = " years of experience", color = Color.Gray, fontSize = 15.sp)

                MSpacer(paddingInDp = 10)

                Box(modifier = Modifier
                    .size(25.dp)
                    .background(color = Color.LightGray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                    ) {
                    Image(painter = painterResource(id = R.drawable.location), contentDescription = null, modifier = Modifier.size(15.dp))
                }

                MSpacer(paddingInDp = 5)

                Text(text = "1.5 km", color = Color.Black, fontWeight = FontWeight.Normal)

                MSpacer(paddingInDp = 10)

                Box(modifier = Modifier
                    .size(25.dp)
                    .background(color = Color.LightGray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.price), contentDescription = null, modifier = Modifier.size(12.dp))
                }

                MSpacer(paddingInDp = 5)

                Text(text = "$20", color = Color.Black, fontWeight = FontWeight.Normal)

            }

        }

    }
}

