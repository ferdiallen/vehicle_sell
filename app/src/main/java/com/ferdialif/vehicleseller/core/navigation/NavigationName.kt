package com.ferdialif.vehicleseller.core.navigation

sealed class NavigationName(val route:String) {
    object HomeScreen : NavigationName("home_screen")
    object DetailScreen : NavigationName("detail_screen")
}