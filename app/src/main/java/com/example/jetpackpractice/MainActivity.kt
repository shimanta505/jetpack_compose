package com.example.jetpackpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Composable
fun TextFieldExample(){
    var textFieldValue by remember {
        mutableStateOf("")
    }
    var trailingIconISVisible by remember {
        mutableStateOf(true)
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
        TextField(value = textFieldValue, onValueChange = {textFieldValue = it}
            , label = {Text("Enter your Email") }
            , singleLine = true
            , modifier = Modifier.width(300.dp)
            , placeholder = {Text("test@email.com")}
           //, visualTransformation =
            , leadingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
            }
            , trailingIcon = {
                IconButton(onClick = {
                    trailingIconISVisible = !trailingIconISVisible
                }) {
                  if ( trailingIconISVisible ) Icon(imageVector = Icons.Outlined.Person, contentDescription = "") else
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
                }
            }
            , keyboardActions = KeyboardActions (
               onGo = {


               }
            ){

            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ShowPreview(){
    JetpackPracticeTheme {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            TextFieldExample()
        }


    }
}


