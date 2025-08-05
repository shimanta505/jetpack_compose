package com.example.jetpackpractice

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpractice.onboardingScreen.OnboardingScreen
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                   // color = MaterialTheme.colorScheme.background,
                ){
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Onboarding") {
//                        composable("Splash") {
//                            SplashScreen(navController = navController, context = this@MainActivity)
//                        }
                        composable("Onboarding") {
                            OnboardingScreen(navController = navController, context = this@MainActivity)
                        }
//                        composable("Home") {
//                            HomeScreen()
//                        }
                    }
                }
            }
           // ShowPreview()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldView(){

}



@Preview(showBackground = true)
@Composable
fun ShowPreview(){
    JetpackPracticeTheme {
        ScaffoldView()
    }
}


