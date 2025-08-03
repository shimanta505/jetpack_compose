package com.example.jetpackpractice

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShowPreview()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldView(){
    Scaffold(
        topBar = {
              TopAppBar(title = {
                Text("top app bar", color = Color.Blue)
              },
                navigationIcon = {
                    IconButton(onClick = {}) {

                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        BadgedBox(
                            modifier = Modifier.size(20.dp),
                            badge = {
                            Badge(content = {Text("10", fontSize = 10.sp)})
                        }
                        ) {
                            Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "favorite item icon")
                        }
                    }
                    IconButton(onClick = {}) {

                        Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "cart items")
                    }
                },

            )
        }
    ) {padding ->
        Column(modifier = Modifier.padding(padding))
        {  }
    }
}



@Preview(showBackground = true)
@Composable
fun ShowPreview(){
    JetpackPracticeTheme {
        ScaffoldView()
    }
}


