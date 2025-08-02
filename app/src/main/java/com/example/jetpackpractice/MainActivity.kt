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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme
import kotlin.random.Random
import kotlin.random.nextInt

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
fun AnnotatedStringExample(){
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 30.sp)){
            append("H")
        }
        append("ello")
        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 30.sp)){
            append("G")
        }
        append("ood")
        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 30.sp)){
            append("P")
        }
        append("eople")
    })
}

@Composable
fun TextStyling(){
    Text("lorem ipsum text".repeat(10), modifier = Modifier
        .background(color = Color.Transparent)
        .fillMaxWidth()
        , color = Color.Black, fontSize = 22.sp
        ,fontStyle = FontStyle.Italic, letterSpacing = 2.sp
        ,textAlign = TextAlign.Start, lineHeight = 40.sp
        , overflow = TextOverflow.Ellipsis
        , maxLines = 5
    )
}


@Preview(showBackground = true)
@Composable
fun ShowPreview(){
    JetpackPracticeTheme {
        Column {
            AnnotatedStringExample()
            TextStyling()
        }


    }
}


