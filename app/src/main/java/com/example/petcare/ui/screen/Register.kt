package com.example.petcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.AuthScreens
import com.example.petcare.ui.screen.textFields.MTextField
import com.example.petcare.ui.screen.textFields.MTextFieldPass
import com.example.petcare.ui.theme.Fb
import com.example.petcare.ui.theme.Google
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
fun RegisterPreview() {
    Register(navController = null)
}

@Composable
fun Register(navController: NavHostController?) {
    val context = LocalContext.current
    val firstNameState = remember { mutableStateOf("") }
    val firstNameFocus = remember { mutableStateOf((false)) }

    val emailState = remember { mutableStateOf("") }
    val emailFocus = remember { mutableStateOf((false)) }

    val passState = remember { mutableStateOf("") }
    val passFocus = remember { mutableStateOf((false)) }

    val passwordVisibility = remember { mutableStateOf(false) }

    var rulesCheckState by remember{ mutableStateOf(false) }

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
                text = "Registration",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.5f), elevation = CardDefaults.cardElevation(10.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .padding(20.dp, 0.dp, 20.dp, 0.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(text = "Full Name", color = Violet)

                    MTextField(
                        hintText = "Enter Name Here",
                        text = firstNameState.value,
                        textColor = Color.Black,
                        keyboardOptions = KeyboardOptions.Default,
                        onFocusChanged = { focusState -> firstNameFocus.value = focusState }) {
                        firstNameState.value = it
                    }

                    Divider(
                        thickness = 3.dp,
                        color = if (firstNameFocus.value) Violet else Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp, 0.dp, 20.dp)
                    )

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

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CustomCheckBox(rulesCheckState) {
                            rulesCheckState = !rulesCheckState
                        }

                        MSpacer(paddingInDp = 5)

                        Text(text = "I agree with" , color = Color.Black)

                        MSpacer(paddingInDp = 1)

                        Text(text = "the rules", color = Violet, textDecoration = TextDecoration.Underline)

                    }

                    MSpacer(paddingInDp = 10)

                    Button(onClick = {  }, modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Violet)
                    ) {
                        Text(text = "Sign Up", color = Color.White)

                    }

                }
            }

            MSpacer(paddingInDp = 10)

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                .fillMaxWidth(0.9f)) {
                Divider(thickness = 2.dp, color = Color.Gray, modifier = Modifier.weight(1f))

                Text(text = "or continue with", color = Color.Black, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)

                Divider(thickness = 2.dp, color = Color.Gray, modifier = Modifier.weight(1f))
            }

            MSpacer(paddingInDp = 10)

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(0.9f)) {

                Box(modifier = Modifier
                    .size(60.dp)
                    .background(color = Fb, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.fb), contentDescription = null, modifier = Modifier.size(25.dp))
                }


                Spacer(modifier = Modifier.padding(10.dp))

                Box(modifier = Modifier
                    .size(60.dp)
                    .background(color = Google, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.goooogle), contentDescription = null, modifier = Modifier.size(20.dp))
                }
            }

            MSpacer(paddingInDp = 10)

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(0.9f)) {

                Text(text = "Already have an account?" , color = Color.Black)

                MSpacer(paddingInDp = 1)

                Text(text = "Sign In", color = Violet, fontWeight = FontWeight.Bold, modifier = Modifier.clickable { navController?.navigate(AuthScreens.SignIn.route) })

            }

        }
    }
}

@Composable
fun CustomCheckBox(checkState: Boolean, onCheckChange: () -> Unit) {

    Box(modifier = Modifier
        .size(20.dp)
        .background(
            color = if (checkState) Violet else Color.White,
            shape = RoundedCornerShape(5.dp)
        )
        .border(
            width = if (checkState) 0.dp else 2.dp,
            color = Violet,
            shape = RoundedCornerShape(5.dp)
        )
        .clickable { onCheckChange() },
        contentAlignment = Alignment.Center) {

        if(checkState) {
            Image(painter = painterResource(id = R.drawable.baseline_check_24), contentDescription = null, modifier = Modifier.size(15.dp))
        }
    }

}
