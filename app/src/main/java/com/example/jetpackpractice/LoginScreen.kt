package com.example.jetpackpractice

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackpractice.ui.theme.Black
import com.example.jetpackpractice.ui.theme.BlueGray
import com.example.jetpackpractice.ui.theme.Roboto
import com.example.jetpackpractice.ui.theme.dimes

@Composable
fun LoginScreen(){
    val uiColor = if(isSystemInDarkTheme()) Color.White else Black
    Surface {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            TopSection(uiColor)
            LoginSection()
            SocialMediaSection(uiColor)

        }
    }
}
@Composable
fun SocialMediaSection(color: Color){
    Column(Modifier.fillMaxWidth().padding(horizontal = MaterialTheme.dimes.padding3).padding(vertical = MaterialTheme.dimes.padding3), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Or Continue With ", style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B)))
        Spacer(Modifier.height(MaterialTheme.dimes.medium1)) //20
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            SocialMediaLogin(
                icon = R.drawable.google,
                text = "Google",
                modifier = Modifier.weight(1f),
                onClick = {}
            )
            Spacer(Modifier.width(MaterialTheme.dimes.medium1))
            SocialMediaLogin(
                icon = R.drawable.facebook,
                text = "Google",
                modifier = Modifier.weight(1f),
                onClick = {}
            )
        }
        Box(modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.4f), contentAlignment = Alignment.BottomCenter){
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xFF94A3B8),
                    fontSize = 13.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Normal
                )){
                    append("Don't Have an Account?")

                }
                withStyle(style = SpanStyle(
                    color = color,
                    fontSize = 13.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Normal
                )){
                    append("Create a Account")
                }
            })
        }
    }
}

@Composable
fun LoginSection(){
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = MaterialTheme.dimes.padding5)) {
        LoginTextField(
            label = "Email",
            trailing = "",
        )
        Spacer(Modifier.height(MaterialTheme.dimes.small2))
        LoginTextField(
            label = "password",
            trailing = ""
        )
        Spacer(Modifier.height(MaterialTheme.dimes.small2))
        Button(modifier = Modifier.fillMaxWidth().height(MaterialTheme.dimes.medium3), onClick = {},
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
fun TopSection(color: Color){
    Column(modifier = Modifier.fillMaxWidth()) {

        Box(contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(.46f),
                painter = painterResource(R.drawable.shape),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primaryContainer),
                contentScale = ContentScale.FillBounds
            )

            Row(modifier = Modifier.padding(top = MaterialTheme.dimes.paddingBig2), verticalAlignment = Alignment.CenterVertically){
                Icon(
                    modifier = Modifier.size(MaterialTheme.dimes.medium3),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(R.string.app_logo),
                    tint = color
                )
                Spacer(Modifier.width(MaterialTheme.dimes.small3))
                Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
                    Text(text = stringResource(id = R.string.the_tolet), style = MaterialTheme.typography.headlineMedium, color = color)
                    Text(text = stringResource(R.string.find_house), style = MaterialTheme.typography.titleSmall, color = color)

                }
            }
            Box(Modifier.fillMaxSize(.43f),contentAlignment = Alignment.BottomCenter){
                Text(modifier = Modifier.padding(bottom = MaterialTheme.dimes.padding1),
                    text = stringResource( R.string.login), style = MaterialTheme.typography.headlineLarge, color = Color.White)

            }
        }


    }
}

@Composable
@Preview(heightDp = 800, widthDp = 300, device = "id:pixel_7a")
fun LoginPreview(){

}