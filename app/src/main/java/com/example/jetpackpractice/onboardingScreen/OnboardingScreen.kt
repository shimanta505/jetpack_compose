package com.example.jetpackpractice.onboardingScreen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jetpackpractice.MainActivity
import com.example.jetpackpractice.R
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(navController: NavHostController,context: MainActivity) {

    val listOfAnimation = listOf(
        R.raw.intro1,
        R.raw.intro2,
        R.raw.intro3,
    )

    val titles = listOf(
        "Explore the skies",
        "Seaside escapes",
        "Garden Getaways"
    )

    val description = listOf(
        "Discover unbeatable deals on air travel to destination around the globe.",
        "Embark on unforgettable journeys to renowned beachfront destinations",
        "Experience the finest city and garden tours right at your finger tips with your app."
    )

    val pagerState= rememberPagerState(pageCount = { listOfAnimation.size })

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        HorizontalPager(pagerState, Modifier.wrapContentSize()) { currentPage ->
            Column(
                Modifier.wrapContentSize().padding(26.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                val composition by rememberLottieComposition(
                    spec = LottieCompositionSpec.RawRes(listOfAnimation[currentPage]))
                LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever
                , modifier = Modifier.size(400.dp)
                )
                Text(text = titles[currentPage], textAlign = TextAlign.Center, fontSize = 44.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = description[currentPage], textAlign = TextAlign.Center, fontSize = 20.sp,
                    modifier = Modifier.padding(top = 40.dp)
                )

                PageIndicator(listOfAnimation.size,currentPage, Modifier.padding(top = 60.dp))
            }

        }

        ButtonSection(listOfAnimation.size,pagerState,navController)

    }
}

@Composable
fun ButtonSection(pageSize: Int,pagerState: PagerState,navController: NavHostController){

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize().padding(30.dp).background(color = Color.Transparent)) {
        if(pagerState.currentPage < pageSize -1){
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxSize()){
                Text("Prev", fontSize = 22.sp, fontWeight = FontWeight.Bold
                    , modifier =  Modifier.clickable(){
                        scope.launch {
                            var currentPage: Int = pagerState.currentPage
                            if(currentPage > 0){
                                pagerState.scrollToPage(pagerState.currentPage -1)
                            }
                        }
                    })
                Text("Next",fontSize = 22.sp, fontWeight = FontWeight.Bold
                    ,modifier =  Modifier.clickable(){
                        scope.launch {
                            var currentPage: Int = pagerState.currentPage
                            if(currentPage < pageSize -1){
                                pagerState.scrollToPage(pagerState.currentPage+1)
                            }
                        }

                    })

            }
        }else if(pagerState.currentPage == pageSize -1){ // checking is it the last page
            OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth().align(alignment = Alignment.BottomCenter)) {
                Text("Get Started", fontSize = 22.sp, fontWeight = FontWeight.Bold
                    , modifier =  Modifier.clickable(){})
            }
        }
    }
}

@Composable
fun PageIndicator(pageCount: Int,currentPage: Int,modifier: Modifier){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ){
        repeat(pageCount){
            IndicatorSingleDot(isSelected = it == currentPage)
        }
    }
}

@Composable
fun IndicatorSingleDot(isSelected: Boolean){

    val width by animateDpAsState(targetValue = if(isSelected) 35.dp else 15.dp)
    Box(modifier = Modifier.padding(2.dp).height(15.dp).width(width).clip(CircleShape)
        .background(if(isSelected) Color(0xFFE92F1E) else Color(0x25E92F1E))
    )
}