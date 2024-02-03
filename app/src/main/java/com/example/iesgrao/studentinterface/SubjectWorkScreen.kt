package com.example.iesgrao.studentinterface

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.mainscreens.NavigationActivity
import com.example.iesgrao.ui.theme.IESGRAOTheme

@Composable
fun MyWork(navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val text = createRef()

        Column(
            modifier = Modifier
                .constrainAs(text) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .padding(16.dp)

        ) {
            NoWork()
            ReturnToSubjects(navController = navController)
        }
    }
}

@Composable
fun NoWork() {
    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp),
        text = "No tienes tareas pendientes",
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ReturnToSubjects(navController: NavController) {
    FloatingActionButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        onClick = { navController.navigate(NavigationActivity.StudentSubjects.route) }
    ) {
        Text(text = "Volver a Asignaturas")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SubjectsWorkPreview() {
    IESGRAOTheme {
        ConstraintLayout {
            val navController = rememberNavController()
            MyWork(navController = navController)
        }
    }
}