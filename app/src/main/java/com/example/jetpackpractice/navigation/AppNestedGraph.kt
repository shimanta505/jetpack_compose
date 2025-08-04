package com.example.jetpackpractice.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.jetpackpractice.sealedModel.Screens

fun NavGraphBuilder.AppNestedGraph(navController: NavController) {
    navigation(startDestination = Screens.ScreenHomeRoute.route, route = Screens.ScreenAppRoute.route){

    }
}