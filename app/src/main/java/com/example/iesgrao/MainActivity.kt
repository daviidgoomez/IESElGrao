package com.example.iesgrao

import MyTeachers
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.ui.theme.IESGRAOTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IESGRAOTheme {
                val navigationController = rememberNavController()

                var isAppClosed by remember {
                    mutableStateOf(false)
                }


                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

                NavHost(
                    navController = navigationController,
                    startDestination = NavigationActivity.LoginScreenMain.route
                ) {
                    composable(NavigationActivity.LoginScreenMain.route) {
                        LoginScreen(navController = navigationController)
                        TitleText {
                            isAppClosed = true
                            finish()
                        }
                        linkPageFooter()
                        InformationText()
                    }
                    composable(NavigationActivity.HomeScreenStudent.route) {
                        AppStructure(navigationController)
                    }
                    composable(NavigationActivity.CourseInfo.route) {
                        MyInfoContent(navigationController)
                    }
                    composable(NavigationActivity.StudentTeachers.route) {
                        MyTeachers(navigationController)
                    }
                    composable(NavigationActivity.ErasmusPlus.route) {
                        MyErasmus(navigationController)
                    }
                    composable(NavigationActivity.ErasmusAccreditations.route) {
                        MyAccreditation(navigationController)
                    }
                    composable(NavigationActivity.StudentSatisfaction.route) {
                        MySatisfaction(navigationController)
                    }
                    composable(NavigationActivity.SendScreen.route) {
                        MySend(navigationController)
                    }
                    composable(NavigationActivity.StudentSubjects.route) {
                        MySubjects(navigationController)
                    }
                    }
            }



        }
    }
}


