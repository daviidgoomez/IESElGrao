package com.example.iesgrao

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
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
import com.example.iesgrao.ui.theme.IESGRAOTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MySubjects(navController: NavHostController) {
    LazyColumn(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {

        item { SubjectTitle() }
        item { SubjectContent() }
    }
}
@Composable
fun SubjectTitle() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Mis Asignaturas",modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center)

    }
    Divider(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp))
}

@Composable
fun SubjectContent() {
    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SubjectsPreview() {
    IESGRAOTheme {
        ConstraintLayout {
            val navController = rememberNavController()
            MySubjects(navController = navController)
        }
    }
}