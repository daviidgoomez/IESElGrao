package com.example.iesgrao

sealed class NavigationActivity (val route:String) {
    object LoginScreenMain:NavigationActivity("Login")
    object HomeScreenStudent:NavigationActivity("HomeStudent/{username}/{password}")
        fun createRoute(username:String, password:String) = "HomeStudent/$username/$password"
    object CourseInfo:NavigationActivity("CourseInfo")
    object StudentTeachers:NavigationActivity("Teachers")
    object StudentSubjects:NavigationActivity("Subjects")
    object StudentSatisfaction:NavigationActivity("Satisfaction")
    object ErasmusPlus:NavigationActivity("Erasmus")


    // ---------------------------------- //
    object HomeScreenTeacher:NavigationActivity("HomeTeacher")
    object HomeScreenAdministrator:NavigationActivity("HomeAdmin")

}

