package com.example.petcare.ui.screen.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MFields(value: String, hint: String, onValueChanged: (String) -> Unit) {
    BasicTextField(value = value, onValueChange = onValueChanged, modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 5.dp, 0.dp, 5.dp),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 15.sp
        ),
        decorationBox = { innerTextField ->

            if(value.isEmpty()) {
                Text(text = hint, color = Color.Black, fontSize = 15.sp)
            }

            innerTextField()
        }
    )
}