package com.example.jetpackpractice.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpackpractice.sealedModel.Screens

fun NavGraphBuilder.AuthNestedGraph(navController: NavController) {
    navigation(startDestination = Screens.ScreenLoginRoute.route, route = Screens.ScreenAuthRoute.route){
        composable(route = Screens.ScreenLoginRoute.route) {
            //login screen
        }
        composable(route = Screens.ScreenRegisterRoute.route) {
            //register screen
        }
        composable(route = Screens.ScreenForgetPasswordRoute.route) {
            //forget password screen
        }
    }
}