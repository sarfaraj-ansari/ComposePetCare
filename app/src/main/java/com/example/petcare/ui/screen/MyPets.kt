package com.example.petcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.theme.ButtonBackColor
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
private fun MyPetsPreview() {
    MyPets(NavHostController(LocalContext.current))
}

@Composable
fun MyPets(navController: NavHostController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)) {

        Header(onClicked = {
            navController.popBackStack()
        })

        repeat(2) {
            PetItem()
        }

        MSpacer(paddingInDp = 15)

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(color = ButtonBackColor, shape = RoundedCornerShape(8.dp))
                .clickable { navController.navigate(MainScreens.AddPetDetails.route) }
        )
        {

            Image(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )

            MSpacer(paddingInDp = 5)

            Text(
                text = "Add another pet",
                color = Violet,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }

}

@Composable
fun Header(onClicked: () -> Unit) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(30.dp)) {

        Image(
            painter = painterResource(id = R.drawable.back_arrow),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterStart)
                .clickable { onClicked.invoke() }
            )

        Text(
            text = "Profile",
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(id = R.drawable.plus),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterEnd)
        )

    }

}

@Composable
fun PetItem() {

    MSpacer(paddingInDp = 10)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(15.dp)
        ) {

            val (edit, pen, profileImage, petName, breed) = createRefs()

            Text(text = "Edit", color = Violet, fontSize = 15.sp, modifier = Modifier.constrainAs(edit) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            })

            Image(
                painter = painterResource(id = R.drawable.pen),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(pen) {
                        top.linkTo(parent.top)
                        end.linkTo(edit.start, margin = 5.dp)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.dog),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .constrainAs(profileImage) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(pen.bottom, margin = 5.dp)
                    }
            )

            Text(
                text = "Troy",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.constrainAs(petName) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(profileImage.bottom, margin = 15.dp)
                }
            )

            Text(
                text = "Toy terrier",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.constrainAs(breed) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(petName.bottom)
                }
            )

        }

    }
}