package com.example.petcare.ui.screen

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.petcare.R
import com.example.petcare.ui.navigation.MainScreens
import com.example.petcare.ui.screen.common.Gender
import com.example.petcare.ui.screen.common.ImageChooser
import com.example.petcare.ui.screen.common.MFields
import com.example.petcare.ui.screen.common.ProfileTopBar
import com.example.petcare.ui.theme.UnCheckedTrackColor
import com.example.petcare.ui.theme.Violet

@Preview
@Composable
private fun AddPetDetailsPreview() {
    AddPetDetails(navController = NavHostController(LocalContext.current))
}

@Composable
fun AddPetDetails(navController: NavHostController) {
    val scrollState = rememberScrollState()
    var imageUri:Uri? by remember { mutableStateOf(null) }
    val launcher: ManagedActivityResultLauncher<PickVisualMediaRequest, Uri?> = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        imageUri = uri
    }

    var genderState by remember { mutableStateOf("male") }

    Column(modifier = Modifier.fillMaxSize()) {
        ProfileTopBar(title = "Add Pet Detail", goBack = { navController.popBackStack() }, skipClick = { navController.navigate(MainScreens.AddOwnerDetails.route)})

        Divider(thickness = 1.dp)

        Column(modifier = Modifier.verticalScroll(state = scrollState, enabled = true)) {

            ImageChooser(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                imageUri = imageUri
            ) { launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly)) }

            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {

                GeneralInformation()

                MSpacer(paddingInDp = 10)

                Title(title = "Gender")

                MSpacer(paddingInDp = 5)

                //Gender Chooser
                Row(modifier = Modifier.fillMaxWidth()) {

                    Gender(
                        text = "Male",
                        backColor = if(genderState == "male") Violet else Color.White,
                        textColor = if(genderState == "male") Color.White else Color.Black,
                        width = if(genderState == "male") 0.dp else 2.dp,
                        icon = R.drawable.male_symbol,
                        modifier = Modifier.weight(1f),
                        onClicked = { genderState = "male" })

                    MSpacer(paddingInDp = 10)

                    Gender(text = "Female",
                        backColor = if(genderState == "female") Violet else Color.White,
                        textColor = if(genderState == "female") Color.White else Color.Black,
                        width = if(genderState == "female") 0.dp else 2.dp, icon = R.drawable.female_symbol,
                        modifier = Modifier.weight(1f),
                        onClicked = { genderState = "female"})
                }

                MSpacer(paddingInDp = 15)

                AdditionalInformation()

                MSpacer(paddingInDp = 15)

                Button(onClick = { navController.navigate(MainScreens.AddOwnerDetails.route) }, modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp), colors = ButtonDefaults.buttonColors(containerColor = Violet)) {

                    Text(text = "Next", color = Color.White, fontSize = 18.sp)
                }

                MSpacer(paddingInDp = 10)

            }

        }

    }
}

@Composable
fun GeneralInformation() {
    var petNameState by remember { mutableStateOf("") }
    var petSpeciesState by remember { mutableStateOf("") }
    var petBreedState by remember { mutableStateOf("") }
    var petSizeState by remember { mutableStateOf("") }

    Text(text = "General\ninformation", fontWeight = FontWeight.Bold, fontSize = 18.sp)

    MSpacer(paddingInDp = 2)

    Title(title = "Pet’s name")

    MFields(value = petNameState, hint = "Enter pet name here") { value ->
        petNameState = value
    }

    Divider()

    MSpacer(paddingInDp = 10)

    Title(title = "Species of your pet")

    MFields(value = petSpeciesState, hint = "Enter pet species here") { value ->
        petSpeciesState = value
    }

    Divider()

    MSpacer(paddingInDp = 10)

    Title(title = "Breed")

    MFields(value = petBreedState, hint = "Enter pet breed here") { value ->
        petBreedState = value
    }

    Divider()

    MSpacer(paddingInDp = 10)

    Title(title = "Size (Optional)")

    MFields(value = petSizeState, hint = "Enter pet size here") { value ->
        petSizeState = value
    }

    Divider()
}

@Composable
fun Title(title: String) {
    Text(text = title, color = Color.Gray, fontSize = 15.sp, fontWeight = FontWeight.Medium)
}

@Composable
fun SwitchContainer(title: String, checked: Boolean, onCheckChanged: (Boolean) -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(30.dp)) {

        Text(text = title , fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterStart), textAlign = TextAlign.Center)

        Switch(
            modifier = Modifier.align(Alignment.CenterEnd),
            checked = checked,
            onCheckedChange = onCheckChanged,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Violet,
                uncheckedTrackColor = UnCheckedTrackColor,
                checkedBorderColor = Violet,
                uncheckedBorderColor = Color.Gray
            ),
            thumbContent = { Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White, shape = CircleShape)) }
        )
    }
}

@Composable
fun AdditionalInformation() {
    var neuteredChecked by remember { mutableStateOf(false) }
    var vaccinatedChecked by remember { mutableStateOf(false) }
    var friendlyWithDogsChecked by remember { mutableStateOf(false) }
    var friendlyWithCatsChecked by remember { mutableStateOf(false) }
    var friendlyWithBelowTenKidsChecked by remember { mutableStateOf(false) }
    var microChippedChecked by remember { mutableStateOf(false) }
    var purebredChecked by remember { mutableStateOf(false) }

    Text(text = "Additional Information", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)

    SwitchContainer(title = "Neutered", checked = neuteredChecked) { neuteredChecked = !neuteredChecked }

    MSpacer(paddingInDp = 10)

    SwitchContainer(title = "Vaccinated", checked = vaccinatedChecked) { vaccinatedChecked = !vaccinatedChecked }

    MSpacer(paddingInDp = 10)

    SwitchContainer(title = "Friendly with dogs", checked = friendlyWithDogsChecked) { friendlyWithDogsChecked = !friendlyWithDogsChecked }

    MSpacer(paddingInDp = 10)

    SwitchContainer(title = "Friendly with cats", checked = friendlyWithCatsChecked) { friendlyWithCatsChecked = !friendlyWithCatsChecked }

    MSpacer(paddingInDp = 10)

    SwitchContainer(title = "Friendly with kids <10 years", checked = friendlyWithBelowTenKidsChecked) { friendlyWithBelowTenKidsChecked = !friendlyWithBelowTenKidsChecked }

    MSpacer(paddingInDp = 10)

    SwitchContainer(title = "MicroChipped", checked = microChippedChecked) { microChippedChecked = !microChippedChecked }

    MSpacer(paddingInDp = 10)

    SwitchContainer(title = "Purebred", checked = purebredChecked) { purebredChecked = !purebredChecked }

}