package com.example.petcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.petcare.data.CategoryListData
import com.example.petcare.data.getProfileOptions
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.theme.ButtonBackColor
import com.example.petcare.ui.theme.PaleGray
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
private fun ProfilePreview() {
    Profile(navController = NavHostController(LocalContext.current))
}

@Composable
fun Profile(navController: NavHostController) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(color = ButtonBackColor)) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(15.dp)
            ) {

                val (edit, pen, profile, profileImage, userName) = createRefs()

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

                Text(
                    text = "Profile",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.constrainAs(profile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .constrainAs(profileImage) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(profile.bottom, margin = 15.dp)
                        }
                )

                Text(
                    text = "Maria Martinez",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.constrainAs(userName) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(profileImage.bottom, margin = 15.dp)
                    }
                )

            }

        }

        MSpacer(paddingInDp = 5)

        repeat(getProfileOptions().size) { index ->
            val data: CategoryListData = getProfileOptions()[index]
            OptionListItem(data) {
                if(index == 0) {
                    navController.navigate(MainScreens.MyPets.route)
                }
            }
        }

        MSpacer(paddingInDp = 10)
    }
}

@Composable
fun OptionListItem(data: CategoryListData, onClick: () -> Unit) {

    MSpacer(paddingInDp = 15)

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 15.dp, end = 15.dp)) {
        val (image, title, divider, arrow) = createRefs()
        Box(modifier = Modifier
            .constrainAs(image) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            .size(50.dp)
            .background(color = Color.LightGray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(Violet)
                )
        }

        Text(
            text = data.category,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp
            ),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.top)
                bottom.linkTo(image.bottom)
                start.linkTo(image.end, margin = 10.dp)
            }
        )

        Box(modifier = Modifier
            .height(0.5.dp)
            .fillMaxWidth()
            .padding(start = 45.dp)
            .background(color = Color.Gray)
            .constrainAs(divider) {
                start.linkTo(parent.start)
                bottom.linkTo(image.bottom)
                end.linkTo(parent.end)
            })

        Image(
            painter = painterResource(id = R.drawable.arrow_right_24),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .clickable { onClick.invoke() }
                .constrainAs(arrow) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            colorFilter = ColorFilter.tint(color = Color.Gray)
            )

    }

}