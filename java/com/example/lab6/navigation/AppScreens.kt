package com.example.lab6.navigation

sealed class AppScreens(val route: String){
    object Galeria:AppScreens( "Galeria")
    object login:AppScreens( "login")

}