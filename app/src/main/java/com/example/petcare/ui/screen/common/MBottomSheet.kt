package com.example.petcare.ui.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petcare.R
import com.example.petcare.data.getAllSpecialists
import com.example.petcare.data.getPopularSpecialists
import com.example.petcare.ui.screen.MSpacer
import com.example.petcare.ui.theme.Violet
import com.example.petcare.ui.theme.Yellow

@Preview
@Composable
private fun SheetDetailPreview() {
   // SheetDetail({}, {})
}

@Preview
@Composable
private fun SpecialityDetailsPreview() {
   // SpecialityDetails({})
}




//AddPetDetailsBottomSheet   AddPetDetailsBottomSheet  AddPetDetailsBottomSheet
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPetDetailsBottomSheet(
    isSheetVisible: Boolean,
    onDismissRequest: () -> Unit,
    addPetClicked: () -> Unit,
    noLaterClicked: () -> Unit,
) {

    if (isSheetVisible) {
        ModalBottomSheet(
            onDismissRequest = { onDismissRequest.invoke() },
            containerColor = Color.Transparent,
            dragHandle = null
        ) {
            SheetDetail(addPetClicked = addPetClicked, noLaterClicked = noLaterClicked)
        }
    }
}

@Composable
fun SheetDetail(addPetClicked: () -> Unit, noLaterClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .background(color = Color.White)
    ) {
        Text(text = "Add Pet Detail", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        MSpacer(paddingInDp = 10)

        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .background(Yellow, CircleShape)
                )

                MSpacer(paddingInDp = 5)

                Text(text = "Faster check-in at appointment.", fontSize = 20.sp)
            }

            MSpacer(paddingInDp = 5)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .background(Yellow, CircleShape)
                )

                MSpacer(paddingInDp = 5)

                Text(
                    text = "Schedule of vaccination, haircuts,\ninspections etc.",
                    fontSize = 20.sp
                )
            }

            MSpacer(paddingInDp = 5)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .background(Yellow, CircleShape)
                )

                MSpacer(paddingInDp = 5)

                Text(text = "Reminder of the upcoming events\nwith your pet.", fontSize = 20.sp)
            }


        }

        MSpacer(paddingInDp = 10)

        Row(modifier = Modifier.fillMaxWidth(0.85f)) {
            Button(
                onClick = addPetClicked,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Violet)
            ) {
                Text(text = "+ Add", color = Color.White, fontWeight = FontWeight.Bold)
            }

            MSpacer(paddingInDp = 6)

            Button(
                onClick = noLaterClicked,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text(text = "No, later", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

//SelectSpecialityBottomSheet    SelectSpecialityBottomSheet    SelectSpecialityBottomSheet
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectSpecialityBottomSheet(isVisible: Boolean, onDismissRequest: () -> Unit, onSpecialityChoose: () -> Unit) {

    if (isVisible) {
        ModalBottomSheet(containerColor = Color.White, onDismissRequest = onDismissRequest) {
            SpecialityDetails(closeSheet = onDismissRequest, onSpecialityChoose = onSpecialityChoose)
        }
    }

}

@Composable
private fun SpecialityDetails(closeSheet: () -> Unit, onSpecialityChoose: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.CenterStart)
                    .clickable { closeSheet.invoke() }
            )

            Text(
                text = "Select a speciality",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(text = "POPULAR SPECIALITIES", color = Yellow, fontSize = 14.sp)

        MSpacer(paddingInDp = 5)

        LazyColumn {
            items(getPopularSpecialists()) {
                Text(
                    text = it,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp).clickable { onSpecialityChoose.invoke() },
                    fontSize = 15.sp
                )
            }
        }

        MSpacer(paddingInDp = 15)

        Text(text = "ALL SPECIALITIES", color = Yellow, fontSize = 14.sp)

        MSpacer(paddingInDp = 5)

        LazyColumn {
            items(getAllSpecialists()) {
                Text(
                    text = it,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp).clickable { onSpecialityChoose.invoke() },
                    fontSize = 15.sp
                )
            }
        }
    }
}

