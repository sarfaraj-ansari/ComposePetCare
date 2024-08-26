package com.example.petcare.ui.screen.textFields

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petcare.R
import com.example.petcare.ui.theme.Violet

@Composable
fun MTextField(hintText: String, text: String, textColor: Color, keyboardOptions: KeyboardOptions, onFocusChanged: (Boolean) -> Unit, onTextChange: (String) -> Unit) {

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 5.dp, 0.dp, 5.dp)
            .onFocusChanged { focusState -> onFocusChanged.invoke(focusState.isFocused) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        cursorBrush = SolidColor(textColor),
        value = text,
        onValueChange = onTextChange,
        textStyle = TextStyle(
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        ),
        decorationBox = { innerTextField ->

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                if (text.isEmpty()) {
                    Text(
                        text = hintText,
                        color = Color.Gray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.weight(.9f)
                    )
                }
            }
            innerTextField()
        }
    )
}

@Composable
fun MTextFieldPass(
    hintText: String,
    text: String,
    passwordVisibility: MutableState<Boolean>,
    onFocusChanged: (Boolean) -> Unit,
    onTextChange: (String) -> Unit
) {

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp, 0.dp, 5.dp)
                .weight(0.9f)
                .onFocusChanged { focusState -> onFocusChanged.invoke(focusState.isFocused) },
            visualTransformation = if(passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true,
            value = text,
            onValueChange = onTextChange,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily.Default
            ),
            decorationBox = { innerTextField ->

                Text(
                    text = /*if (text.isEmpty()) hintText else*/ "",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Default,
                )

                innerTextField()
            }
        )

        Image(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = "", modifier = Modifier
            .size(20.dp)
            .weight(0.1f)
            .clickable { passwordVisibility.value = !passwordVisibility.value }, alignment = Alignment.Center)

        Spacer(modifier = Modifier.padding(5.dp))
    }
}