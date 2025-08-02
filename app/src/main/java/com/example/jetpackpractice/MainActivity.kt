package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            ColorBox(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier){
    val color = remember { mutableStateOf(Color.Yellow) }

    Box(modifier = modifier.background(color = color.value).clickable{
        val red = Random.nextInt(range = IntRange(0,255))
        val green = Random.nextInt(range = IntRange(0,255))
        val blue = Random.nextInt(range = IntRange(0,255))
        color.value = Color(
            red,
            green,
            blue,
            0xFF
        )
        println("red || $red green || $green blue || $blue")
    }){

    }
}

@Composable
fun imageCard(){
    val painter: Painter = painterResource(id = R.drawable.quotes)
    val description: String = "kermit playing in the show"
    val title:String = "he is playing very well"

    Box(modifier = Modifier.fillMaxWidth(0.5f).padding(16.dp)) {
        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)){
            Box(modifier = Modifier.height(200.dp).fillMaxWidth()){
                Image(painter = painter,contentDescription = description,
                    contentScale = ContentScale.FillWidth)

                Box(modifier = Modifier.fillMaxSize().background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black),
                        startY = 300f
                    )
                ))
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ){
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }

}
