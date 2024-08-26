package com.example.petcare.ui.screen.common

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petcare.R

@Composable
fun ImageChooser(modifier: Modifier, imageUri: Uri?, chooseImage: () -> Unit) {
    Box(modifier = modifier.padding(top = 10.dp))
    {

        if(imageUri != null) {
            AsyncImage(
                model = imageUri,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .align(Alignment.Center)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.dog),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .align(Alignment.Center)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.add_icon),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.TopEnd)
                .clip(CircleShape)
                .clickable { chooseImage.invoke() },

            )
    }
}