package com.example.laboratorio6.screens

import androidx.annotation.DrawableRes
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

data class ResourceImage(
    @DrawableRes
    val id: Int,
    val title: String,
    val author: String,
    val year: String
)

@Composable
fun Galeria(navController: NavHostController) {

    // Lista de imágenes que se mostrarán en la galería.
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image6,
        // Agrega aquí más imágenes según tus necesidades.
    )
    val images2 = listOf(
        R.drawable.img01,
        R.drawable.img02,
        R.drawable.img03,
        R.drawable.img04,
        R.drawable.img06,
        // Agrega aquí más imágenes según tus necesidades.
    )

    // Estado para realizar un seguimiento de la imagen actual.
    var currentImageIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Muestra la imagen actual.
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

        // Botones de "Anterior" y "Siguiente".
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    // Cambia a la imagen anterior si es posible.
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