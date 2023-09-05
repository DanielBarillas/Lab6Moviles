package com.example.lab6.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lab6.R


@Composable
fun Galeria(navController: NavHostController) {

    val images = listOf(
        R.drawable.licensed_image__1_,
        R.drawable.licensed_image__1_,
        R.drawable.licensed_image__31_,
        R.drawable.licensed_image__41__,
        R.drawable.licensed_image__51___,
    )
    val images2 = listOf(
        R.drawable._1,
        R.drawable._2,
        R.drawable._3,
        R.drawable._4,
        R.drawable._5,
    )

    var currentImageIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[currentImageIndex]),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
        Image(
            painter = painterResource(id = images2[currentImageIndex]),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .width(230.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentImageIndex > 0) {
                        currentImageIndex--
                    }
                },
                enabled = currentImageIndex > 0
            ) {
                Text("Anterior")
            }

            Button(
                onClick = {
                    // Cambia a la imagen siguiente si es posible.
                    if (currentImageIndex < images.size - 1) {
                        currentImageIndex++
                    }
                },
                enabled = currentImageIndex < images.size - 1
            ) {
                Text("Siguiente")
            }
        }
    }
}