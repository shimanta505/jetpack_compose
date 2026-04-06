package com.example.jetpackpractice

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackpractice.ui.theme.Black
import com.example.jetpackpractice.ui.theme.BlueGray
import com.example.jetpackpractice.ui.theme.backgroundImageColor
import java.nio.file.WatchEvent

@Composable
fun LoginScreen(){
    Surface {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            TopSection()
            LoginSection()
        }
    }
}

@Composable
fun LoginSection(){
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp)) {
        LoginTextField(
            label = "Email",
            trailing = "",
        )
        Spacer(Modifier.height(20.dp))
        LoginTextField(
            label = "password",
            trailing = ""
        )
        Spacer(Modifier.height(20.dp))
        Button(modifier = Modifier.fillMaxWidth().height(40.dp), onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = if(isSystemInDarkTheme()) BlueGray else Black,
                contentColor = Color.White
            ), shape = RoundedCornerShape(size = 4.dp)
        ) {
            Text(text = "Log in", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
        }
    }

}
@Composable
fun TopSection(){
    Column(modifier = Modifier.fillMaxWidth()) {
        val uiColor = if(isSystemInDarkTheme()) Color.White else Black

        Box(contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(.46f),
                painter = painterResource(R.drawable.shape),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primaryContainer),
                contentScale = ContentScale.FillBounds
            )

            Row(modifier = Modifier.padding(top = 80.dp), verticalAlignment = Alignment.CenterVertically){
                Icon(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(R.string.app_logo),
                    tint = uiColor
                )
                Spacer(Modifier.width(15.dp))
                Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
                    Text(text = stringResource(id = R.string.the_tolet), style = MaterialTheme.typography.headlineMedium, color = uiColor)
                    Text(text = stringResource(R.string.find_house), style = MaterialTheme.typography.titleSmall, color = uiColor)

                }
            }
            Box(Modifier.fillMaxSize(.43f),contentAlignment = Alignment.BottomCenter){
                Text(modifier = Modifier.padding(bottom = 10.dp),
                    text = stringResource( R.string.login), style = MaterialTheme.typography.headlineLarge, color = Color.White)

            }
        }


    }
}

@Composable
@Preview(heightDp = 800, widthDp = 300, device = "id:pixel_7a")
fun LoginPreview(){
    TopSection()
}