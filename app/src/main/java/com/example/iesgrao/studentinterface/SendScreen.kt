package com.example.iesgrao.studentinterface

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
fun MySend(navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val content = createRef()
        Column(
            modifier = Modifier
                .constrainAs(content) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .padding(16.dp)
        ) {
            ExitSend()
            HomeButton(navController = navController)
        }
    }
}

@Composable
fun ExitSend() {
    Text(
        text = "Cuestionario enviado con éxito. ¡Gracias!",
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HomeButton(navController: NavController) {
    FloatingActionButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        onClick = { navController.navigate(NavigationActivity.HomeScreenStudent.route) }
    ) {
        Text(text = "Volver al Home")
    }
}

@Preview(showBackground = true)
@Composable
fun SendPreview() {
    IESGRAOTheme {
        val navController = rememberNavController()
        MySend(navController = navController)
    }
}
