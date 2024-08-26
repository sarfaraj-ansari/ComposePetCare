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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.petcare.R
import com.example.petcare.ui.theme.ButtonBackColor
import com.example.petcare.ui.theme.Gray
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
fun Appointments() {
    var checkState: String by remember { mutableStateOf("upcoming") }
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
                .padding(start = 15.dp, end = 15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "Appointments", style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.SemiBold))

                MSpacer(paddingInDp = 20)

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(40.dp)

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
                                    color = if (checkState == "upcoming") Violet else Color.Transparent,
                                    shape = CircleShape
                                )
                                //click without ripple effect
                                .pointerInput(Unit) {
                                    detectTapGestures(onPress = {
                                        checkState = "upcoming"
                                    })
                                }, contentAlignment = Alignment.Center
                        ) {
                            androidx.compose.material3.Text(
                                text = "Upcoming",
                                color = if (checkState == "upcoming") Color.White else Color.Black
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .background(
                                    color = if (checkState == "past") Violet else Color.Transparent,
                                    shape = CircleShape
                                )
                                //click without ripple effect
                                .pointerInput(Unit) {
                                    detectTapGestures(onPress = {
                                        checkState = "past"
                                    })
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            androidx.compose.material3.Text(
                                text = "Past",
                                color = if (checkState == "past") Color.White else Color.Black
                            )
                        }

                    }

                }

                MSpacer(paddingInDp = 10)
            }

        }

        MSpacer(paddingInDp = 10)

        if(checkState == "upcoming") {
            Upcoming()
        } else {
            Past()
        }
    }
}

@Preview
@Composable
private fun Upcoming() {
    LazyColumn {
        items(5) {
            UpcomingAppointmentListItem() {

            }
        }
    }
}

@Preview
@Composable
private fun Past() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = R.drawable.clock),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            colorFilter = ColorFilter.tint(color = Color.Gray)
        )

        MSpacer(paddingInDp = 15)

        Text(text = "No appointments yet", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold)

    }
}

@Preview
@Composable
private fun UpcomingAppointmentListItem() {
    UpcomingAppointmentListItem({})
}
@Composable
fun UpcomingAppointmentListItem(onIteClicked: () -> Unit) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(start = 10.dp, end = 10.dp, top = 7.dp, bottom = 7.dp)
        .clickable { onIteClicked.invoke() },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(modifier = Modifier
            .wrapContentSize()
            .padding(15.dp)
            .background(color = Color.White),
            verticalArrangement = Arrangement.Center
        ) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            ) {

                Image(painter = painterResource(id = R.drawable.profile_photo), contentDescription = null, modifier = Modifier
                    .size(95.dp)
                    .clip(shape = RoundedCornerShape(15.dp)))

                MSpacer(paddingInDp = 10)

                Column {

                    androidx.compose.material3.Text(
                        text = "Alekseenko Vasily",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    MSpacer(paddingInDp = 3)

                    androidx.compose.material3.Text(
                        text = "Veterinary Dentist",
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )

                    MSpacer(paddingInDp = 5)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.rating), contentDescription = null)

                        androidx.compose.material3.Text(text = "125 Reviews")
                    }

                    MSpacer(paddingInDp = 5)

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(modifier = Modifier
                            .size(20.dp)
                            .background(color = Color.LightGray, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.location), contentDescription = null, modifier = Modifier.size(12.dp))
                        }

                        MSpacer(paddingInDp = 3)

                        androidx.compose.material3.Text(
                            text = "1.5 km",
                            color = Color.Black,
                            fontWeight = FontWeight.Normal
                        )

                        MSpacer(paddingInDp = 5)

                        Box(modifier = Modifier
                            .size(20.dp)
                            .background(color = Color.LightGray, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.price), contentDescription = null, modifier = Modifier.size(10.dp))
                        }

                        MSpacer(paddingInDp = 3 )

                        androidx.compose.material3.Text(
                            text = "$20",
                            color = Color.Black,
                            fontWeight = FontWeight.Normal
                        )

                    }
                }

            }

            MSpacer(paddingInDp = 5)

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = ButtonBackColor, shape = RoundedCornerShape(15.dp))
                    .padding(10.dp)
            ) {

                val (box1, t1, t2, box2, t3) = createRefs()

                Box(modifier = Modifier
                    .constrainAs(box1) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .size(35.dp)
                    .background(color = Color.LightGray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.price), contentDescription = null, modifier = Modifier.size(15.dp))
                }

                Text(
                    text = "Veterinary clinic \"Alden-Vet\"",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(t1) {
                        top.linkTo(box1.top)
                        start.linkTo(box1.end, 10.dp)
                    }
                )

                Text(
                    text = "141 N Union Ave, Los Angeles, CA",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.constrainAs(t2) {
                        top.linkTo(t1.bottom, 1.dp)
                        start.linkTo(box1.end, 10.dp)
                    }
                )



                Box(modifier = Modifier
                    .constrainAs(box2) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(35.dp)
                    .background(color = Color.LightGray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.clock), contentDescription = null, modifier = Modifier.size(18.dp), colorFilter = ColorFilter.tint(
                        Color.Black))
                }

                Text(
                    text = "Wed 9 Sep — 10:30 am",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(t3) {
                        top.linkTo(box2.top)
                        start.linkTo(box2.end, 10.dp)
                        bottom.linkTo(box2.bottom)
                    }
                )
            }

            MSpacer(paddingInDp = 10)

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Violet)
                ) {
                    androidx.compose.material3.Text(text = "Edit", color = Color.White, fontWeight = FontWeight.Bold)
                }

                MSpacer(paddingInDp = 10)

                Button(
                    onClick = {
                              },
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonBackColor)
                ) {
                    androidx.compose.material3.Text(text = "Cancel", color = Color.Black, fontWeight = FontWeight.Bold)
                }
            }

        }

    }
}