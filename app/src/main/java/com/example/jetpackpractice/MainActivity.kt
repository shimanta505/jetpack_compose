package com.example.jetpackpractice

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
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
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackpractice.model.NavItemModel
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
    val items = listOf(
        NavItemModel(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false,
            badgeNum = 0
        ),
        NavItemModel(
            title = "Inbox",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasBadge = true,
            badgeNum = 10
        ),
        NavItemModel(
            title = "Account",
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            hasBadge = true,
            badgeNum = 5
        )
    )

    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("App bar") })
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index,item ->
                    NavigationBarItem(
                        selected = bottomNavState == index,
                        onClick = { bottomNavState = index },
                        icon = {

                            BadgedBox(badge = {
                                if (item.hasBadge) Badge { }
                                if (item.badgeNum != 0) Badge {
                                    Text(text = item.badgeNum.toString())
                                }
                            }, content = {

                            })
                            Icon(
                                imageVector = if(bottomNavState == index) item.selectedIcon
                                else item.unselectedIcon,
                                contentDescription = "nav icon"
                            )
                        },
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) {contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(items[bottomNavState].title,
                fontWeight = FontWeight.ExtraBold, fontSize = 30.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowPreview(){
    JetpackPracticeTheme {
        ScaffoldView()
    }
}


