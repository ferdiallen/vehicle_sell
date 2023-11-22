package com.ferdialif.vehicleseller.core.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.model.Motorcycle
import com.ferdialif.vehicleseller.presentation.detailscreen.DetailScreen
import com.ferdialif.vehicleseller.presentation.homescreen.HomeScreen
import com.ferdialif.vehicleseller.presentation.homescreen.HomeViewModel
import com.ferdialif.vehicleseller.utils.toListSerializer
import com.ferdialif.vehicleseller.utils.toVehicleClass

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    controller: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = controller,
        startDestination = NavigationName.HomeScreen.route
    ) {
        composable(route = NavigationName.HomeScreen.route, enterTransition = {
            fadeIn(tween(200))
        }, exitTransition = {
            fadeOut(tween(200))
        }) {
            val viewModel:HomeViewModel = hiltViewModel()
            HomeScreen(onNavigateToDetailScreen = {
                if (it is Car) {
                    it.toListSerializer()?.let { data ->
                        controller.navigate(NavigationName.DetailScreen.route + "/${data}")
                    }
                } else if (it is Motorcycle) {
                    it.toListSerializer()?.let {data->
                        controller.navigate(NavigationName.DetailScreen.route+"/${data}")
                    }
                }
            }, viewModel = viewModel)
        }
        composable(
            route = NavigationName.DetailScreen.route + "/{data}", arguments = listOf(
                navArgument("data") {
                    type = NavType.StringType
                }
            ), enterTransition = {
                slideInHorizontally(tween(400), initialOffsetX = {
                    it - 200
                })
            }, exitTransition = {
                slideOutHorizontally(tween(400), targetOffsetX = {
                    it
                })
            }
        ) {
            val carData = it.arguments?.getString("data")?.toVehicleClass() as? Car
            val motorcycle = it.arguments?.getString("data")?.toVehicleClass() as? Motorcycle
            DetailScreen(car = carData, motorcycle = motorcycle, onBackPress = {
                controller.popBackStack()
            })
        }
    }
}