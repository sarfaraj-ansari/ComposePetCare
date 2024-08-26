package com.example.petcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.theme.ButtonBackColor
import com.example.petcare.ui.theme.Violet
import com.example.petcare.ui.theme.Yellow

@Preview
@Composable
private fun SpecialistDetailsPreview() {
    SpecialistDetails(NavHostController(LocalContext.current))
}
@Composable
fun SpecialistDetails(navController: NavHostController) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState, enabled = true)
    ) {

        Header(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
        )

        MSpacer(paddingInDp = 45)

        Column(
            Modifier
                .wrapContentSize()
                .padding(start = 15.dp, end = 15.dp)
        ) {

            Text(
                text = "“He was friendly and diligent in getting to the\nright diagnosis and presciption.” ",
                style = TextStyle(color = Color.Black, fontSize = 15.sp)
            )

            MSpacer(paddingInDp = 5)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "a verified review", color = Color.Gray)

                MSpacer(paddingInDp = 5)

                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .background(color = Color.Green, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_check_24),
                        contentDescription = null,
                        modifier = Modifier.size(10.dp)
                    )
                }
            }

            MSpacer(paddingInDp = 5)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.rating),
                    contentDescription = null,
                    modifier = Modifier.align(alignment = Alignment.CenterStart)
                )

                Text(
                    text = "View all 125 reviews",
                    style = TextStyle(
                        color = Violet,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.align(alignment = Alignment.CenterEnd)
                )
            }

            MSpacer(paddingInDp = 10)

            Details()

            MSpacer(paddingInDp = 10)

            Reviews()

            MSpacer(paddingInDp = 5)

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(color = ButtonBackColor, shape = RoundedCornerShape(8.dp))
            )
            {

                Image(
                    painter = painterResource(id = R.drawable.review_write),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )

                MSpacer(paddingInDp = 5)

                Text(
                    text = "Write a Review",
                    color = Violet,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            MSpacer(paddingInDp = 10)

            NearByVet()
        }

        BottomBar() {
            navController.navigate(MainScreens.BookingConfirm.route)
        }

    }

}

@Composable
fun Header(modifier: Modifier) {

    ConstraintLayout(
        modifier = modifier
    ) {

        val (headerButtons, specialistInfo) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.specialist_photo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            contentScale = ContentScale.Crop
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(headerButtons) {
                    top.linkTo(parent.top)
                }
        ) {

            val (backImage, share, favourite) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(backImage) {
                        top.linkTo(parent.top, margin = 15.dp)
                        start.linkTo(parent.start, margin = 15.dp)
                    },
                colorFilter = ColorFilter.tint(color = Color.White)
            )

            Image(painter = painterResource(id = R.drawable.share),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(share) {
                        top.linkTo(favourite.top)
                        end.linkTo(favourite.start, margin = 15.dp)
                    })

            Image(painter = painterResource(id = R.drawable.heart),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(favourite) {
                        top.linkTo(parent.top, margin = 15.dp)
                        end.linkTo(parent.end, margin = 15.dp)
                    })

        }


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(start = 15.dp, end = 15.dp)
                .constrainAs(specialistInfo) {
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.bottom)
                }, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(20.dp)
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color.White)
                    .padding(15.dp)
            ) {


                val (userName, speciality, experience, row, ratingContainer, rating, reviews) = createRefs()

                Text(
                    text = "Alekseenko Vasily",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.constrainAs(userName) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    })

                Text(
                    text = "Veterinary Dentist",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    ),
                    modifier = Modifier.constrainAs(speciality) {
                        top.linkTo(userName.bottom)
                        start.linkTo(userName.start)
                    }
                )

                Text(
                    text = "10 years of experience",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.constrainAs(experience) {
                        top.linkTo(speciality.bottom, margin = 5.dp)
                        start.linkTo(userName.start)
                    }
                )

                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .constrainAs(row) {
                            top.linkTo(experience.bottom, margin = 10.dp)
                            start.linkTo(userName.start)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .background(color = Color.LightGray, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.price),
                            contentDescription = null,
                            modifier = Modifier.size(10.dp)
                        )
                    }

                    MSpacer(paddingInDp = 5)

                    Text(text = "$20", color = Color.Black, fontWeight = FontWeight.Normal)

                    MSpacer(paddingInDp = 10)

                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .background(color = Color.LightGray, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = null,
                            modifier = Modifier.size(10.dp)
                        )
                    }

                    MSpacer(paddingInDp = 5)

                    Text(text = "1.5 km", color = Color.Black, fontWeight = FontWeight.Normal)

                }

                Image(
                    painter = painterResource(id = R.drawable.rating_bg),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .constrainAs(ratingContainer) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        })

                Text(
                    text = "4.9",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.constrainAs(rating) {
                        top.linkTo(ratingContainer.top)
                        bottom.linkTo(ratingContainer.bottom)
                        start.linkTo(ratingContainer.start)
                        end.linkTo(ratingContainer.end)
                    }
                )

                Text(
                    text = "120 reviews",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    ),
                    modifier = Modifier.constrainAs(reviews) {
                        end.linkTo(parent.end)
                        bottom.linkTo(row.bottom)

                    })

            }

        }

    }

}

@Composable
fun ProExperience(text: String) {

    MSpacer(paddingInDp = 5)

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

        val (dot, tv) = createRefs()

        Box(modifier = Modifier
            .size(10.dp)
            .background(color = Yellow, shape = CircleShape)
            .constrainAs(dot) {
                top.linkTo(parent.top, margin = 3.dp)
                start.linkTo(parent.start)
            }
        )

        Text(text = text,
            fontSize = 12.sp,
            modifier = Modifier.constrainAs(tv) {
                top.linkTo(parent.top)
                start.linkTo(dot.end, margin = 5.dp)
            })

    }

}

@Preview
@Composable
fun Details() {

    Column {

        Text(
            text = "Biography",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )

        MSpacer(paddingInDp = 5)

        Text(
            text = "Alekseenko Vasily Vasilyevich, born in 1974\n" +
                    "Master of Veterinary Medicine\n" +
                    "Leading doctor Veterinary clinic \"Alden-Vet\"\n" +
                    "Specialization: clinical diagnostics, surgery vet, dentist",
            fontSize = 12.sp
        )

        MSpacer(paddingInDp = 10)

        Text(
            text = "Education",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )

        MSpacer(paddingInDp = 5)

        Text(
            text = "Before entering the agricultural Academy he worked at the department of surgery of the veterinary faculty (1991-1992). He graduated from the Faculty of Veterinary Medicine\n" +
                    "of NAU in 1997. He defended his thesis at the Department\n" +
                    "of Surgery on the topic: \"Surgery on the urinary organs\n" +
                    "of cats.\" Scientific advisor prof. Borisevich V.B. In 1998 graduated from the Magistracy.",
            fontSize = 12.sp
        )

        MSpacer(paddingInDp = 10)

        Text(
            text = "Professional experience",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )

        ProExperience("Repeated participant and winner of the International Conferences, reports on the topic: “Iatrogenic pathology in urology”, “Foreign bodies of the gastrointestinal tract in small domestic animals” ")

        ProExperience(
            "From 1998 to 2001, he was the chief physician of the\n" +
                    "Equus veterinary medicine clinic."
        )

        ProExperience(
            "Constantly increases the level of his qualifications,\n" +
                    "attending international conferences, congresses, \n" +
                    "workshops on veterinary services for small pets."
        )

        ProExperience(
            "Since 2006, the leading doctor of veterinary care \"UCCA\". At the same time, she continues to conduct reception \n" +
                    "at the Equus veterinary medicine clinic, where he has been working since 1997."
        )

        MSpacer(paddingInDp = 10)

        Text(
            text = "Personal information",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )

        MSpacer(paddingInDp = 5)

        Text(
            text = "Candidate master of sports in equestrian sport \n" +
                    "(dressage). Favorite breed of dog is German Shepherd. \n" +
                    "He is married, has two children: daughter Alika and son Timur.",
            fontSize = 12.sp
        )

    }

}

@Preview
@Composable
fun Reviews() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
    {
        Text(
            text = "Reviews",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Text(
            text = "View all 125 reviews",
            style = TextStyle(
                color = Violet,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.align(alignment = Alignment.CenterEnd)
        )
    }

    MSpacer(paddingInDp = 5)

    LazyRow {
        items(10) {
            ReviewListItem()
        }
    }
}

@Composable
@Preview
fun NearByVet() {

    Text(
        text = "Nearby vet",
        style = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    )

    MSpacer(paddingInDp = 5)

    LazyRow {
        items(5) {
            NearbyVetListItem()
        }
    }

}

@Preview
@Composable
private fun BottomBarPreview() {
    BottomBar({})
}
@Composable
fun BottomBar(bookClicked: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    )
    {

        ConstraintLayout(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)) {

            val (price, tv, row, btn) = createRefs()

            Text(
                text = "$20",
                style = TextStyle(color = Color.Black,
                fontWeight = FontWeight.Bold, fontSize = 18.sp),
                modifier = Modifier.constrainAs(price) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(row.top)
                }
            )

            Text(
                text = " / first visit",
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.constrainAs(tv) {
                    start.linkTo(price.end)
                    bottom.linkTo(price.bottom)
                })

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.constrainAs(row) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(price.bottom)
                }) {
                Image(
                    painter = painterResource(id = R.drawable.rating),
                    contentDescription = null
                )

                MSpacer(paddingInDp = 5)

                Text(text = "125 Reviews")
            }

            Button(
                onClick = {
                          bookClicked.invoke()
                }, modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .height(50.dp)
                    .constrainAs(btn) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Violet
                )
            ) {
                Text(text = "Book", color = Color.White, fontSize = 18.sp)
            }

        }

    }

}

@Preview
@Composable
fun ReviewListItem() {

    ConstraintLayout(
        modifier = Modifier
            .height(165.dp)
            .padding(start = 4.dp, end = 4.dp)
    ) {

        val (card, userImage, userName, rating) = createRefs()

        Card(
            modifier = Modifier
                .height(150.dp)
                .width(250.dp)
                .constrainAs(card) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            shape = RoundedCornerShape(15.dp)
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
            ) {

                val (row, date, review) = createRefs()

                val annotatedString = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black, fontSize = 12.sp)) {
                        append("Thank you very much! Great clinic! The dog was limping, X-rayed, prescribed quality treatment. Dog of fights! Excellent specialists!")
                    }
                    pushStringAnnotation(tag = "Click", annotation = "")

                    withStyle(
                        style = SpanStyle(
                            color = Violet,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(" more")
                    }

                    pop()
                }

                ClickableText(
                    text = annotatedString,
                    modifier = Modifier.constrainAs(review) {
                        start.linkTo(parent.start)
                        bottom.linkTo(row.top, margin = 5.dp)
                    },
                    onClick = { offSet ->
                        annotatedString.getStringAnnotations(
                            tag = "Click",
                            start = offSet,
                            end = offSet
                        ).firstOrNull()?.let {
                            println("clickedddddd")
                        }
                    })

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.constrainAs(row) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    })
                {
                    Text(text = "a verified review", color = Color.Black, fontSize = 12.sp)

                    MSpacer(paddingInDp = 2)

                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(color = Color.Green, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_check_24),
                            contentDescription = null,
                            modifier = Modifier.size(6.dp)
                        )
                    }
                }

                Text(text = "26.02.2019", fontSize = 12.sp, modifier = Modifier.constrainAs(date) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                })

            }

        }

        Card(
            modifier = Modifier
                .size(50.dp)
                .constrainAs(userImage) {
                    top.linkTo(parent.top)
                    start.linkTo(card.start, margin = 20.dp)
                },
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.specialist_photo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop

            )
        }

        Text(
            text = "Ann & Leo",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            ),
            modifier = Modifier.constrainAs(userName) {
                start.linkTo(userImage.end, margin = 10.dp)
                top.linkTo(card.top)
                bottom.linkTo(rating.top)
            }
        )

        Image(
            painter = painterResource(id = R.drawable.rating),
            contentDescription = null,
            modifier = Modifier.constrainAs(rating) {
                start.linkTo(userImage.end, margin = 10.dp)
                bottom.linkTo(userImage.bottom)
            }
        )
    }

}

@Composable
@Preview
fun NearbyVetListItem() {

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(130.dp)
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(color = Color.White),
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                )

                MSpacer(paddingInDp = 10)

                Column {

                    Text(
                        text = "Lauren Sell",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    MSpacer(paddingInDp = 1)

                    Text(
                        text = "Veterinary Dentist",
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )

                    MSpacer(paddingInDp = 2)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.rating),
                            contentDescription = null
                        )

                        Text(text = "125 Reviews")
                    }
                }

            }

            MSpacer(paddingInDp = 5)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "10",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(text = " years of experience", color = Color.Gray, fontSize = 15.sp)

                MSpacer(paddingInDp = 10)

                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .background(color = Color.LightGray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                }

                MSpacer(paddingInDp = 5)

                Text(text = "1.5 km", color = Color.Black, fontWeight = FontWeight.Normal)

                MSpacer(paddingInDp = 10)

                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .background(color = Color.LightGray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.price),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )
                }

                MSpacer(paddingInDp = 5)

                Text(text = "$20", color = Color.Black, fontWeight = FontWeight.Normal)

            }

        }

    }

}