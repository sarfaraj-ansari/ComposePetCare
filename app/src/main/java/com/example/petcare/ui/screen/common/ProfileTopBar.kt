package com.example.petcare.ui.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.petcare.R
import com.example.petcare.ui.theme.Violet

@Composable
fun ProfileTopBar(title: String, goBack: () -> Unit, skipClick: () -> Unit) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.back_arrow),
            contentDescription = null,
            modifier = Modifier.size(15.dp).clickable { goBack.invoke() }
        )

        Text(text = title, modifier = Modifier.weight(1f), textAlign = TextAlign.Center, color = Color.Black, fontWeight = FontWeight.Bold)

        Text(text = "Skip", modifier = Modifier.clickable { skipClick.invoke() }, color = Violet)

    }

}