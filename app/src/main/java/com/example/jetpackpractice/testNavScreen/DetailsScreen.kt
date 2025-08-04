package com.example.jetpackpractice.testNavScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.jetpackpractice.sealedModel.Screens

@Composable
fun DetailsScreen(navController: NavController) {
    NavWidget("DetailsScreen", Screens.ScreenHomeRoute,navController)
}