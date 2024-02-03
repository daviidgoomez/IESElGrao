package com.example.iesgrao.studentinterface

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.datafiles.SubjectInformation
import com.example.iesgrao.datafiles.subjects
import com.example.iesgrao.mainscreens.NavigationActivity
import com.example.iesgrao.ui.theme.IESGRAOTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MySubjects(navController: NavHostController) {
    LazyColumn(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {

        item { SubjectTitle() }
        items(subjects) { subject ->
            SubjectContent(subject = subject, navController)
        }
        item { SubjectHome(navController = navController) }
    }
}

@Composable
fun SubjectTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Text(
            text = "Mis Asignaturas",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }
    Divider(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp))
}

@Composable
fun SubjectContent(subject: SubjectInformation, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(NavigationActivity.SubjectWork.route) }
            .clip(RoundedCornerShape(8.dp)),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = subject.picture),
                contentDescription = "Subject Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = subject.nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Horas: ${subject.num_horas}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subject.descripcion ?: "",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,

            )
        }
    }
}

@Composable
fun SubjectHome(navController: NavHostController) {
    Button(
        onClick = {
            navController.navigate(NavigationActivity.HomeScreenStudent.route)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = "Ir al Home",
        )
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