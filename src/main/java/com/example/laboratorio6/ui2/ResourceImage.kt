package com.example.laboratorio6.ui2

import androidx.annotation.DrawableRes
import com.example.laboratorio6.R

data class ResourceImage(
    @DrawableRes
    val id: Int,
    val title: String,
    val author: String,
    val year: String
        )

fun getResources(): List<ResourceImage> {
    return listOf(
        ResourceImage(R.drawable.licensed_image__1_, "La Joconde", "Leonardo da Vinci", "(1503 - 1519)"),
        ResourceImage(R.drawable.licensed_image__2_, "L'ultima cena", "Leonardo da Vinci", "(1495 - 1498)"),
        ResourceImage(R.drawable.licensed_image__3_, "Salvator Mundi", "Leonardo da Vinci", "(1500)"),
        ResourceImage(R.drawable.licensed_image__4_, "La dama con l'ermellino", "Leonardo da Vinci", "(1489 – 1491)"),
        ResourceImage(R.drawable.licensed_image__5_, "Sant'Anna, la Madonna, il Bambino", "Leonardo da Vinci", "(c. 1503)"),
    )
}