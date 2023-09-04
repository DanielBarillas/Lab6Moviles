package com.example.laboratorio6.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio6.screens.Galeria
import com.example.laboratorio6.screens.MainActivity

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Galeria.route) {
        composable(AppScreens.Galeria.route) {
            AppScreens.login(navController)
        }
        composable(AppScreens.Galeria.route) {
            AppScreens.Galeria(navController)
        }
    }
}