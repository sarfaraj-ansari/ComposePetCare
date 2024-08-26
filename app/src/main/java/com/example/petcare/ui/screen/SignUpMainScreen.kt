package com.example.petcare.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.AuthScreens
import com.example.petcare.ui.theme.Violet
import com.example.petcare.ui.theme.Yellow

@Preview
@Composable
private fun SignUpMainScreenPreview() {
    SignUpMainScreen(NavHostController(LocalContext.current))
}
@Composable
fun SignUpMainScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.background_violet_gradient),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column {

            Text(
                text = "Welcome",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(
                    text = "to",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = " Pet Care",
                    color = Yellow,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Image(painter = painterResource(id = R.drawable.fb_icon), contentDescription = "", modifier = Modifier.size(25.dp))

                Spacer(modifier = Modifier.padding(5.dp))

                Text(text = "Continue with", color = Violet, fontSize = 15.sp)

                Text(text = " Facebook", color = Violet, fontSize = 15.sp, fontWeight = FontWeight.Bold)

            }

            Spacer(modifier = Modifier.padding(10.dp))

            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {

                Image(painter = painterResource(id = R.drawable.google), contentDescription = "", modifier = Modifier.size(25.dp))
                Spacer(modifier = Modifier.padding(5.dp))

                Text(text = "Continue with", color = Violet, fontSize = 15.sp)

                Text(text = " Google   ", color = Violet, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .border(BorderStroke(2.dp, color = Color.White), shape = RoundedCornerShape(30.dp))
                .clickable { navController.navigate(AuthScreens.Register.route) },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {

                Text(text = "Register with Email", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)

            }

            Spacer(modifier = Modifier.padding(20.dp))

            Row(modifier = Modifier.fillMaxWidth(0.8f), horizontalArrangement = Arrangement.Center) {
                Text(text = "Already have an account?", color = Color.White, fontSize = 15.sp)
                Text(text = " Sign In", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold, modifier = Modifier.clickable { navController.navigate(AuthScreens.SignIn.route) })
            }
        }

    }
}