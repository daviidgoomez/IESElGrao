package com.example.iesgrao

sealed class NavigationActivity (val route:String) {
    object LoginScreen:NavigationActivity("Login/{username, password}")
    object HomeScreenStudent:NavigationActivity("HomeStudent")
    object HomeScreenTeacher:NavigationActivity("HomeTeacher")
    object HomeScreenAdministrator:NavigationActivity("HomeAdmin")

}

