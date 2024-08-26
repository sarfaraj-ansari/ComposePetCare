package com.example.petcare.ui.screen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.activity.AuthActivity
import com.example.petcare.ui.activity.MainActivity
import com.example.petcare.ui.navigation.AuthScreens
import com.example.petcare.ui.screen.textFields.MTextField
import com.example.petcare.ui.screen.textFields.MTextFieldPass
import com.example.petcare.ui.theme.Fb
import com.example.petcare.ui.theme.Google
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
fun SignInPreview() {
    SignIn(navController = null)
}

@Composable
fun SignIn(navController: NavHostController?) {
    val context = LocalContext.current
    val emailState = remember { mutableStateOf("") }
    val emailFocus = remember { mutableStateOf((false)) }

    val passState = remember { mutableStateOf("") }
    val passFocus = remember { mutableStateOf((false)) }

    val passwordVisibility = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_violet_gradient),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {

            Text(
                text = "Sign In",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.42f), elevation = CardDefaults.cardElevation(10.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .padding(20.dp, 0.dp, 20.dp, 0.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(text = "Email", color = Violet)

                    MTextField(hintText = "Enter Email Here",
                        text = emailState.value,
                        textColor = Color.Black,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        onFocusChanged = { focusState -> emailFocus.value = focusState }) {
                        emailState.value = it
                    }

                    Divider(
                        thickness = 3.dp,
                        color = if (emailFocus.value) Violet else Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp, 0.dp, 20.dp)
                    )

                    Text(text = "Password", color = Violet)

                    MTextFieldPass(hintText = "Enter Pass Here",
                        text = passState.value,
                        passwordVisibility,
                        onFocusChanged = { focusState -> passFocus.value = focusState }) {
                        passState.value = it
                    }

                    Divider(
                        thickness = 3.dp,
                        color = if (passFocus.value) Violet else Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp, 0.dp, 20.dp)
                    )

                    Text(
                        text = "Do not remember the password?",
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { })

                    MSpacer(paddingInDp = 10)

                    Button(
                        onClick = {
                            context.startActivity(Intent(context, MainActivity::class.java))
                            (context as AuthActivity).finish()
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Violet)
                    ) {
                        Text(text = "Sign In", color = Color.White)

                    }

                }
            }

            MSpacer(paddingInDp = 10)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                Divider(thickness = 2.dp, color = Color.Gray, modifier = Modifier.weight(1f))

                Text(
                    text = "or continue with",
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Divider(thickness = 2.dp, color = Color.Gray, modifier = Modifier.weight(1f))
            }

            MSpacer(paddingInDp = 10)

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Fb, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fb),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }


                Spacer(modifier = Modifier.padding(10.dp))

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Google, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.goooogle),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            MSpacer(paddingInDp = 10)

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {

                Text(text = "Don't have account yet?", color = Color.Black)

                MSpacer(paddingInDp = 1)

                Text(
                    text = "Registration",
                    color = Violet,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navController?.navigate(AuthScreens.Register.route) })

            }

        }
    }
}
