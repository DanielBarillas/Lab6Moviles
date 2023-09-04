package com.example.laboratorio6.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.laboratorio6.R
import com.example.laboratorio6.navigation.AppScreens
import com.example.laboratorio6.ui.theme.Laboratorio6Theme
import com.example.laboratorio6.ui2.SecondScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", navController = this)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context: Context? = null, navController: NavController) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    val image = painterResource(id = R.drawable.baseline_app_settings_alt_24)
    val image2 = painterResource(id = R.drawable._200px_biblioteca_montserrat)
    val image3 = painterResource(id = R.drawable.kisspng_computer_icons_user_clip_art_user_5abf13db5624e4_1771742215224718993529)

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Box(modifier = Modifier.align(Alignment.CenterVertically)) {
            }
            Image(
                painter = image,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Green),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(35.dp)
                    .width(35.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .width(170.dp)
                .align(Alignment.Start)
        ) {
            Layout(
                content = {
                    Image(
                        painter = image2,
                        contentDescription = null,
                        alpha = 0.2F,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .height(5.dp)
                            .width(5.dp)
                    )

                    Image(
                        painter = image3,
                        contentDescription = null,
                        modifier = Modifier
                            .height(105.dp)
                            .width(200.dp)
                    )
                }
            ) { measurableList, constraints ->
                val placeables = measurableList.map { it.measure(constraints) }
                layout(constraints.maxWidth, constraints.maxHeight) {
                    placeables[0].place(0, 0) // Posición de la primera imagen
                    placeables[1].place(240, 280) // Posición de la segunda imagen (encima de la primera)
                }
            }
        }
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp
            )
            Text(
                text = "Ingresé su correo y contraseña",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            TextField(modifier = Modifier .padding(20.dp).align(Alignment.CenterHorizontally),
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Correo electrónico") }
            )
            TextField(modifier = Modifier .align(Alignment.CenterHorizontally),
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation()
            )
            Button(onClick = { openSecondScreen(context) },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)) {
                Text(text = "Iniciar Sesión")
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(150.dp)
                .height(100.dp), // Ajusta la altura según tus necesidades

        ) {
            Button(
                onClick = {
                    if (isValidCredentials(userName, password)) {
                        navController.navigate(route = AppScreens.Galeria.route)
                    } else {
                        showError = true
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(150.dp)
            ) {
                Text("Iniciar Sesión", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            }
            if (showError) {
                Text(
                    text = "Las credenciales ingresadas son incorrectas. Por favor, ingreselas nuevamente.",
                    color = Color.Red
                )
            }
        }
    }
}
private fun openSecondScreen(context: Context?) {
    val intent = Intent(context, SecondScreen::class.java)
    context?.startActivity(intent)
}

fun isValidCredentials(username: String, password: String): Boolean {
    return username == "DanielB" && password == "12345678"}

@Preview(
    showBackground = true,
    showSystemUi = true)

@Composable
fun GreetingPreview() {
    Laboratorio6Theme {
        Greeting("Android")
    }
}