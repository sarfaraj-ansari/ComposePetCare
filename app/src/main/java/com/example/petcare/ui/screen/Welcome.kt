@file:OptIn(ExperimentalFoundationApi::class)

package com.example.petcare.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.AuthScreens
import com.example.petcare.ui.theme.Violet
import com.example.petcare.ui.theme.Yellow
import kotlinx.coroutines.launch

@Preview
@Composable
fun WelcomePreview() {
    Welcome(navController = null)
}

@Composable
fun Welcome(navController: NavHostController?) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { 3 })
    val images = listOf<Int>(R.drawable.welcome1, R.drawable.welcome2, R.drawable.welcome3)
    val headings = listOf("Welcome to Pet Care", "Proven experts", "Reliable reviews")
    val desc = listOf(
        "All types of services for your pet in one\nplace, instantly searchable.",
        "We interview every specialist before\nthey get to work",
        "A review can be left only by a user\nwho used the service."
    )
    val btnText = listOf("Next", "Next", "Get Started")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "Sign In", color = Violet, modifier = Modifier
                    .padding(10.dp)
                    .clickable { navController?.navigate(AuthScreens.SignUpMainScreen.route) },
                fontWeight = FontWeight.SemiBold
            )
        }

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth(),
            userScrollEnabled = false
        ) { pageIndex ->

            Image(
                painter = painterResource(id = images[pageIndex]),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
            )

        }

        ThreeDots(pos = pagerState.currentPage)

        MSpacer(paddingInDp = 15)

        Text(
            text = headings[pagerState.currentPage],
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = desc[pagerState.currentPage],
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(5.dp),
            textAlign = TextAlign.Center
        )

        MSpacer(paddingInDp = 15)

        Button(
            onClick = {

                      scope.launch {
                          if(pagerState.currentPage == 2) {
                              navController?.navigate(AuthScreens.SignUpMainScreen.route)
                          } else {
                              pagerState.animateScrollToPage(pagerState.currentPage.plus(1))
                          }
                      }

            }, modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Violet
            )
        ) {
            Text(text = btnText[pagerState.currentPage], color = Color.White, fontSize = 18.sp)
        }

    }

}

@Preview
@Composable
private fun ThreeDotPreview() {
    ThreeDots(1)
}
@Composable
private fun ThreeDots(pos: Int) {

    val roundedModifier = Modifier
        .size(7.dp)
        .background(color = Color.Gray, shape = CircleShape)
    val modifier = Modifier
        .height(7.dp)
        .width(20.dp)
        .background(color = Yellow, shape = RoundedCornerShape(10.dp))

    Row {

        Box(modifier = if(pos == 0) modifier else roundedModifier)

        MSpacer(paddingInDp = 5)

        Box(modifier = if(pos == 1) modifier else roundedModifier)

        MSpacer(paddingInDp = 5)

        Box(modifier = if(pos == 2) modifier else roundedModifier)

    }

}