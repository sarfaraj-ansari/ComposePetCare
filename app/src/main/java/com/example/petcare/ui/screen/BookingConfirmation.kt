package com.example.petcare.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
private fun BookingConfirmationPreview() {
    BookingConfirmation(NavHostController(LocalContext.current))
}
@Composable
fun BookingConfirmation(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background_violet_gradient),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center) {

                Image(
                    painter = painterResource(id = R.drawable.baseline_check_24),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Violet),
                    modifier = Modifier.size(40.dp))

            }

            MSpacer(paddingInDp = 30)

            Text(
                text = "Your appointment\nhas been booked",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            MSpacer(paddingInDp = 10)

            Text(
                text = "Vasilenko Oksana will be waiting\nfor you and your pet",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center
            )

            MSpacer(paddingInDp = 15)

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {

                Image(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )

                MSpacer(paddingInDp = 3)

                Text(
                    text = "Wed 9 Sep at 10:30 am",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )

            }

            MSpacer(paddingInDp = 30)

            Button(
                onClick = { navController.navigate(MainScreens.Appointments.route) },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                border = BorderStroke(2.dp, color = Color.White)) {

                Text(text = "Go to my appointments", color = Color.White)

            }

        }

    }

}