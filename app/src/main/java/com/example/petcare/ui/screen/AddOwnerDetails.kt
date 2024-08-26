package com.example.petcare.ui.screen

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.screen.common.Gender
import com.example.petcare.ui.screen.common.ImageChooser
import com.example.petcare.ui.screen.common.MFields
import com.example.petcare.ui.screen.common.ProfileTopBar
import com.example.petcare.ui.screen.textFields.MTextField
import com.example.petcare.ui.theme.PaleGray
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
private fun AddOwnerDetailsPreview() {
    AddOwnerDetails(navController = NavHostController(LocalContext.current))
}

@Composable
fun AddOwnerDetails(navController: NavHostController) {
    var imageUri: Uri? by remember { mutableStateOf(null) }
    val launcher: ManagedActivityResultLauncher<PickVisualMediaRequest, Uri?> =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            imageUri = uri
        }
    var genderState by remember { mutableStateOf("male") }
    var ownerNameState by remember { mutableStateOf("") }
    var ownerEmailState by remember { mutableStateOf("") }
    var phoneNoState by remember { mutableStateOf("") }
    var aboutMeState by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        ProfileTopBar(title = "Your Profile", goBack = { navController.popBackStack() }, skipClick = { navController.navigate(MainScreens.Search.route)})

        Divider(thickness = 1.dp)

        ImageChooser(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            imageUri = imageUri
        ) { launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly)) }

        Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {

            MSpacer(paddingInDp = 10)

            Title(title = "Full name")

            MFields(value = ownerNameState, hint = "Enter your name here") { value ->
                ownerNameState = value
            }

            MSpacer(paddingInDp = 10)

            Title(title = "Owner")

            MSpacer(paddingInDp = 5)

            //Gender Chooser
            Row(modifier = Modifier.fillMaxWidth()) {

                Gender(
                    text = "Male",
                    backColor = if (genderState == "male") Violet else Color.White,
                    textColor = if (genderState == "male") Color.White else Color.Black,
                    width = if (genderState == "male") 0.dp else 2.dp,
                    icon = R.drawable.male_symbol,
                    modifier = Modifier.weight(1f),
                    onClicked = { genderState = "male" })

                MSpacer(paddingInDp = 10)

                Gender(text = "Female",
                    backColor = if (genderState == "female") Violet else Color.White,
                    textColor = if (genderState == "female") Color.White else Color.Black,
                    width = if (genderState == "female") 0.dp else 2.dp,
                    icon = R.drawable.female_symbol,
                    modifier = Modifier.weight(1f),
                    onClicked = { genderState = "female" })
            }

            MSpacer(paddingInDp = 10)

            Title(title = "Email")

            MFields(value = ownerEmailState, hint = "Enter your email here") { value ->
                ownerEmailState = value
            }

            MSpacer(paddingInDp = 10)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = PaleGray, shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(Modifier.padding(start = 15.dp, end = 15.dp)) {

                    Title(title = "Phone")

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "+91", color = Violet)

                        Text(text = " | ", color = Color.Gray)

                        MTextField(
                            hintText = "9874561230",
                            text = phoneNoState,
                            textColor = Violet,
                            keyboardOptions = KeyboardOptions.Default,
                            onFocusChanged = { }) {
                            phoneNoState = it
                        }
                    }

                }
            }

            MSpacer(paddingInDp = 10)

            Title(title = "About me")

            MSpacer(paddingInDp = 5)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp))
                    .background(color = PaleGray, shape = RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {

                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth(.96f)
                        .height(80.dp),
                    value = aboutMeState,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    ),
                    onValueChange = { aboutMeState = it },
                    decorationBox = { innertextField ->
                        if(aboutMeState.isEmpty()) {
                            Text(text = "Enter here...")
                        }
                        innertextField()
                    }
                )

            }

            MSpacer(paddingInDp = 15)

            Button(onClick = { navController.navigate(MainScreens.Search.route) }, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), colors = ButtonDefaults.buttonColors(containerColor = Violet)) {

                Text(text = "Get Started", color = Color.White, fontSize = 18.sp)
            }

        }
    }
}