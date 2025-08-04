package com.example.jetpackpractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpractice.sealedModel.Screens
import com.example.jetpackpractice.testNavScreen.DetailsScreen
import com.example.jetpackpractice.testNavScreen.HomeScreen

class AppNavigation {
    public val homeScreen:String = "Home"
    public val detailsScreen:String = "Details"


    @Composable
    fun Navigation(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Screens.ScreenHomeRoute.route) {
            composable(route = homeScreen) { HomeScreen(navController) }
            composable(
                route = Screens.ScreenDetailsRoute.route
            ) { DetailsScreen(navController) }
        }
    }


}