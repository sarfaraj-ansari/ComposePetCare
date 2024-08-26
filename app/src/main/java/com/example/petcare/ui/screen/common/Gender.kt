package com.example.petcare.ui.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petcare.ui.screen.MSpacer

@Composable
fun Gender(text: String, backColor: Color, textColor: Color, width: Dp, icon: Int, modifier: Modifier, onClicked: () -> Unit) {

    Row(modifier = modifier
        .height(40.dp)
        .border(width = width, color = Color.Gray, shape = CircleShape)
        .background(color = backColor, shape = CircleShape)
        //click without ripple effect
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                onClicked.invoke()
            })
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier.size(15.dp), colorFilter = ColorFilter.tint(color = textColor))

        MSpacer(paddingInDp = 5)

        Text(text = text, color = textColor, fontSize = 18.sp)

    }

}