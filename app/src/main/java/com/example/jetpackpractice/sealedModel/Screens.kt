package com.example.jetpackpractice.sealedModel

sealed class Screens(val route: String) {
    object ScreenLoginRoute: Screens(route = "Login")
    object ScreenForgetPasswordRoute: Screens(route = "Forget-password")
    object ScreenRegisterRoute: Screens(route = "Register")
    object ScreenHomeRoute: Screens(route = "Home")
    object ScreenDetailsRoute: Screens(route = "Details")
    object ScreenSettingsRoute: Screens(route = "Settings")
    object ScreenProfileRoute: Screens(route = "Profile")
    object ScreenAuthRoute: Screens(route = "Auth")
    object ScreenAppRoute: Screens(route = "App")


}