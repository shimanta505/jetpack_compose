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
import androidx.navigation.Navigation
import com.example.jetpackpractice.sealedModel.Screens

@Composable
fun NavWidget(screenName: String,navTo: Screens,navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(screenName)

        Button(onClick = {
            navController.navigate(navTo.route)
        }){
            Text("pass data to ${navTo.route}")
        }


    }
}